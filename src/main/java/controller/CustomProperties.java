package controller;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app.properties")
public class CustomProperties {
	/**
     * API URI for the IE/UK PostCode service.
     */
    private String server = "http://localhost";
    private String resource = "resource";
    private String apikey = "12345";
    private String endpointie = "endpointie";
    private String endpointuk = "endpointuk";


	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getEndpointie() {
		return endpointie;
	}

	public void setEndpointie(String endpointie) {
		this.endpointie = endpointie;
	}

	public String getEndpointuk() {
		return endpointuk;
	}

	public void setEndpointuk(String endpointuk) {
		this.endpointuk = endpointuk;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

}
