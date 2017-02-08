package beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Address implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("addressline1")
	private String addressline1;
	@JsonProperty("addressline2")
	private String addressline2;
	@JsonProperty("addressline3")
	private String addressline3;
	@JsonProperty("summaryline")
	private String summaryline;
	@JsonProperty("organisation")
	private String organisation;
	@JsonProperty("street")
	private String street;
	@JsonProperty("posttown")
	private String posttown;
	@JsonProperty("county")
	private String county;
	@JsonProperty("postcode")
	private String postcode;
	@JsonProperty("latitude")
	private String latitude;
	@JsonProperty("longitude")
	private String longitude;
	@JsonProperty("buildingname")
	private String buildingname;
	@JsonProperty("premise")
	private String premise;
	@JsonProperty("dependentlocality")
	private String dependentlocality;
	
	public Address (){
		
	}
	public Address(String addressline1, String addressline2, String addressline3, String summaryline,
			String organisation, String street, String posttown, String county, String postcode, String latitude,
			String longitude,String buildingname, String premise, String dependentlocality) {
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.addressline3 = addressline3;
		this.summaryline = summaryline;
		this.organisation = organisation;
		this.street = street;
		this.posttown = posttown;
		this.county = county;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.buildingname = buildingname;
		this.premise = premise;
		this.dependentlocality = dependentlocality;
	}
	
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public String getAddressline3() {
		return addressline3;
	}
	public void setAddressline3(String addressline3) {
		this.addressline3 = addressline3;
	}
	public String getSummaryline() {
		return summaryline;
	}
	public void setSummaryline(String summaryline) {
		this.summaryline = summaryline;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPosttown() {
		return posttown;
	}
	public void setPosttown(String posttown) {
		this.posttown = posttown;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getBuildingname() {
		return buildingname;
	}
	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}
	public String getPremise() {
		return premise;
	}
	public void setPremise(String premise) {
		this.premise = premise;
	}
	public String getDependentlocality() {
		return dependentlocality;
	}
	public void setDependentlocality(String dependentlocality) {
		this.dependentlocality = dependentlocality;
	}
}
