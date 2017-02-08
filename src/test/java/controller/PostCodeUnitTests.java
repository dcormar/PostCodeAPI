package controller;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.annotation.JsonProperty;

import beans.Address;
import beans.AddressRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(PostCodeController.class)
public class PostCodeUnitTests {
	
	@Autowired
	private MockMvc mockMvc;

    @MockBean
    AddressRepository addressRepository;
    
    @Test
    public void getPostCode_ie_ShouldReturnOk() throws Exception {
    	Address [] addresses = {new Address("addressline1", "addressline2", "addressline3", "summaryline",
    			"organisation", "street", "posttown", "county", "postcode", "latitude", "longitude","","","")};
    	
    	when (addressRepository.getByPostCode(anyObject(), anyObject()))
    	.thenReturn(new AsyncResult<Optional<Address[]>>(Optional.of(addresses)));
    	
    	 MvcResult result = mockMvc.perform(get("/findByPostCode/ie/D02X285"))
        		.andExpect(request().asyncStarted())
                .andReturn();
        
        result.getAsyncResult();
        
        mockMvc
        .perform(asyncDispatch(result))
        .andExpect(status().isOk())
        .andExpect(content().json("[{\"addressline1\":\"addressline1\",\"addressline2\":\"addressline2\",\"addressline3\":\"addressline3\",\"summaryline\":\"summaryline\",\"organisation\":\"organisation\",\"street\":\"street\",\"posttown\":\"posttown\",\"county\":\"county\",\"postcode\":\"postcode\",\"latitude\":\"latitude\",\"longitude\":\"longitude\"}]"))
		.andDo(print())
        .andReturn();
    }
    
    @Test
    public void getPostCode_uk_ShouldReturnOk() throws Exception {
    	Address [] addresses = {new Address("addressline1", "addressline2", "addressline3", "summaryline",
    			"organisation", "street", "posttown", "county", "postcode", "latitude", "longitude","buildingname","premise","dependentlocality")};
    	
    	when (addressRepository.getByPostCode(anyObject(), anyObject()))
    	.thenReturn(new AsyncResult<Optional<Address[]>>(Optional.of(addresses)));
    	
    	 MvcResult result = mockMvc.perform(get("/findByPostCode/uk/NR147PZ"))
        		.andExpect(request().asyncStarted())
                .andReturn();
        
        result.getAsyncResult();
        
        mockMvc
        .perform(asyncDispatch(result))
        .andExpect(status().isOk())
        .andExpect(content().json("[{\"addressline1\":\"addressline1\",\"addressline2\":\"addressline2\",\"addressline3\":\"addressline3\",\"summaryline\":\"summaryline\",\"organisation\":\"organisation\",\"street\":\"street\",\"posttown\":\"posttown\",\"county\":\"county\",\"postcode\":\"postcode\",\"latitude\":\"latitude\",\"longitude\":\"longitude\"}]"))
		.andDo(print())
        .andReturn();
    }
    @Test
    public void getPostCode_Null_ShouldReturnBadRequest() throws Exception {
    	Address [] addresses = null;
    	
    	when (addressRepository.getByPostCode(anyObject(), anyObject()))
    	.thenReturn(new AsyncResult<Optional<Address[]>>(Optional.ofNullable(addresses)));
    	
        MvcResult result = mockMvc.perform(get("/findByPostCode/ie/D02X285"))
        		.andExpect(request().asyncStarted())
                .andReturn();
        		
        result.getAsyncResult();
        
        mockMvc .perform(asyncDispatch(result))
        		.andExpect(status().isBadRequest())
        		.andDo(print())
                .andReturn();
    }
}