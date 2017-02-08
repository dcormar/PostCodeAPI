package controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import beans.Address;
import beans.AddressRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class PostCodeIntegrationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
    AddressRepository addressRepository;
    
    @Test
    public void getPostCode_ie() throws Exception {  	
    	ResponseEntity<Address[]> responseEntity = restTemplate.getForEntity("/findByPostCode/ie/{postCode}", Address[].class, "D02X285");
    	
    	Address [] addresses = responseEntity.getBody();
    	
    	assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    	assertEquals("D02 X285",addresses[0].getPostcode());
    }
    
    @Test
    public void getPostCode_uk() throws Exception {  	
    	ResponseEntity<Address[]> responseEntity = restTemplate.getForEntity("/findByPostCode/uk/{postCode}", Address[].class, "NR147PZ");
    	
    	Address [] addresses = responseEntity.getBody();
    	
    	assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    	assertEquals("NR14 7PZ",addresses[0].getPostcode());
    }
    
}
