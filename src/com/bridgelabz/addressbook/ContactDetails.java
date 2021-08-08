package com.bridgelabz.addressbook;

public class ContactDetails {
	private String fname, lname, address, city, state, zip, phone, email;


	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ContactDetails [fname= " + fname + ", lname= " + lname + ", address= " + address + ", city= " + city
				+ ", state= " + state + ", zip= " + zip + ", phone= " + phone + ", email= " + email + "]";
	}
}