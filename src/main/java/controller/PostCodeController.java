package controller;


import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import beans.Address;
import beans.AddressRepository;

@RestController
public class PostCodeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	AddressRepository addressRepository;
	
	
    @RequestMapping(value="/findByPostCode/{country}/{postCode}", method=RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public DeferredResult<ResponseEntity<Address[]>> findByPostCodeIreland(@PathVariable("country") String country,@PathVariable("postCode") String postCode,final HttpServletResponse response) {
    	DeferredResult<ResponseEntity<Address[]>> deferredResult = new DeferredResult<ResponseEntity<Address[]>>();
    	logger.debug("country="+country);
    	logger.debug("postCode="+postCode);
		 CompletableFuture.supplyAsync(() -> {		 
					Optional<Address[]> optional=null;
					try {
						optional = addressRepository.getByPostCode(country,postCode).get();
					} catch (NoSuchElementException e) {
						logger.debug("Address with post code=" + postCode + " for country: " + country + " not found");
					} catch (Exception e) {
						logger.error("Execution exception with post code " + postCode + " for country: " + country,e);
					} return optional;
					})
				 .whenCompleteAsync((result, throwable) -> { 
					 if (result.isPresent()) {
						 logger.debug("result: " +result.get()[0].getAddressline1());
						 deferredResult.setResult(ResponseEntity.status(HttpStatus.OK).body(result.get()));
					 }
					 else {
						 logger.debug("Address with postCode="+postCode+" not found");
						 Address [] addresses = null;
						 deferredResult.setResult(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(addresses));
					 }
				 });	 
    		logger.debug("Servlet thread released");
			return deferredResult;
		}
}
