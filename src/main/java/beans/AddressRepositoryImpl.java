package beans;

import java.util.Optional;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import controller.CustomProperties;

@Service
public class AddressRepositoryImpl implements AddressRepository {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private CustomProperties properties;
	
	@Override
	@Async
	public Future<Optional<Address[]>> getByPostCode(String country, String postCode) {
		Optional <Address[]> optional = getAddresses(country, postCode);
		return new AsyncResult<>(optional);
	}
	
	@Cacheable("Addresses")
	private Optional<Address[]> getAddresses(String country, String postCode) {
		RestTemplate restTemplate = new RestTemplate();
		String server = properties.getServer();
		String resource = properties.getResource();
		String apiKey = properties.getApikey();
		String endPointie = properties.getEndpointie();
		String endPointuk = properties.getEndpointuk();

		String externalApiUri = server +
				resource +
				apiKey +
				(country.equals("ie") ? endPointie : endPointuk) +
				postCode;		
		logger.debug("External Api resource: " + externalApiUri);
		ResponseEntity<Address[]> responseEntity = restTemplate.getForEntity(externalApiUri, Address[].class);
		return Optional.ofNullable(responseEntity.getBody());
	}
}
