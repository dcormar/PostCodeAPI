David Cortijo - Post code REST API - capability test

The project is carried out using the following technologies:

- Spring boot for the bootstrapping.
- Spring MVC for the development of the REST API. Non-blocking and asynchronous techniques carried out by using Spring Boot capabilities as well.
- Spring test for the Unit and Integration testing: using Spring Boot flavour, adding mock services when unit testing. Also, during initial stages of development, a SoapUI project with a Mock server was utilised.
- EHCache for caching Addresses.
- AngularJS for the front-end.

Further details:

- to run the project: mvn spring-
- REST API: accessible through the following URI: http://localhost:8080/findByPostCode/{country}/{postCode} where:
	- Country: "ie" or "uk".
	- PostCode: "NR147PZ", for example.
- Front-end: accessible through either http://localhost:8080/ or http://localhost:8080/index.html
- Details on the 3rd party external APIs to consume for getting the addresses can be found on Spring Boot's "application.properties" file. By default:
	- app.properties.server=http://ws.postcoder.com
	- app.properties.resource=/pcw/
	- app.properties.apikey=PCW45-12345-12345-1234X
	- app.properties.endpointie=/addressgeo/ie/
	- app.properties.endpointuk=/address/uk/
- Details on the caching method (disk persistence) can be found at "ehcache.xml" config file.
- Testing: 
	- Unit tests are developed to test the proper behavior of the REST controllers, for both UK and IE scenarios.
	- Integration tests are developed to test the integration with the 3rd party API and the behavior of the Address Service ("AddressRepositoryImpl.java").
	- Find also attached on GitHub, at the root location of the project, an XML containing the SoapUI project used for initial stages of development, with mock servers on it.
	