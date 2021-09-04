package com.bridgelabz.addressbook.dto;

import java.util.Objects;

public class ContactDetails {
	private String fname, lname, address, city, state, zip, phone, email, addressBookName;

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

	public String getAddressBookName() {
		return addressBookName;
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

	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	@Override
	public String toString() {
		return "[First name= " + fname + ", Last name= " + lname + ", Address= " + address + ", City= " + city
				+ ", State= " + state + ", Zip= " + zip + ", Phone= " + phone + ", Email= " + email + "]" + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactDetails other = (ContactDetails) obj;
		return Objects.equals(fname, other.fname);
	}
}