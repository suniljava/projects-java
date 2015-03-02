package test.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column (name="EMP_CITY")
	private String city;
	
	@Column (name="EMP_STATE")
	private String state;
	
	@Column (name="EMP_ZIPCODE")
	private String zipcode;
	
	@Column (name="EMP_STREET")
	private String street;

	public Address() {}
	
	public Address(String city, String state, String zipcode, String street) {
		super();
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	
	

}
