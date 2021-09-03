package com.bridgelabz.addressbook.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bridgelabz.addressbook.dto.ContactDetails;
import com.bridgelabz.addressbook.service.ContactInterface;
import com.bridgelabz.addressbook.utils.InputUtils;

public class Operations implements ContactInterface {

	private String addressBookName, firstName, lastName, address, city, state, email, zip, phone;
	private static List<ContactDetails> addressBook;
	private HashMap<String, List<ContactDetails>> contactListMap = new HashMap<>();
	ContactDetails contactDetails;

	public void newEntry(String addressBookName, String firstName, String lastName, String address, String city,
			String state, String email, String zip, String phone) {
		contactDetails = new ContactDetails();

		contactDetails.setAddressBookName(addressBookName);
		contactDetails.setFname(firstName);
		contactDetails.setLname(lastName);
		contactDetails.setAddress(address);
		contactDetails.setCity(city);
		contactDetails.setState(state);
		contactDetails.setEmail(email);
		contactDetails.setZip(zip);
		contactDetails.setPhone(phone);

		addressBook = new ArrayList<ContactDetails>();
		addressBook.add(contactDetails);

		contactListMap.put(addressBookName, addressBook);
	}

	public void exitEntry(String addressBookName, String firstName, String lastName, String address, String city,
			String state, String email, String zip, String phone) {
		contactDetails = new ContactDetails();
		contactDetails.setFname(firstName);
		contactDetails.setLname(lastName);
		contactDetails.setAddress(address);
		contactDetails.setCity(city);
		contactDetails.setState(state);
		contactDetails.setEmail(email);
		contactDetails.setZip(zip);
		contactDetails.setPhone(phone);

		addressBook = new ArrayList<ContactDetails>();
		addressBook = contactListMap.get(addressBookName);
		addressBook.add(contactDetails);

		contactListMap.put(addressBookName, addressBook);
	}

	@Override
	public void addContact() {

		char option = 'n';
		System.out.println("You Want to Add in Existing Address Book?(y/n)");
		option = InputUtils.charInput();
		if (option == 'Y' || option == 'y') {
			if (contactListMap.isEmpty()) {
				System.out.println("It is Empty.");
			} else {
				System.out.println("List Address Book Name");

				for (HashMap.Entry item : contactListMap.entrySet()) {
					System.out.println(item.getKey());
				}
				System.out.println();
				System.out.println("Enter Address Book Name");
				addressBookName = InputUtils.strInput();
				System.out.println("Enter First Name");
				firstName = InputUtils.strInput();
				System.out.println("Enter Last Name");
				lastName = InputUtils.strInput();
				System.out.println("Enter Address");
				address = InputUtils.strInput();
				System.out.println("Enter City Name");
				city = InputUtils.strInput();
				System.out.println("Enter State Name");
				state = InputUtils.strInput();
				System.out.println("Enter Email");
				email = InputUtils.strInput();
				System.out.println("Enter Zip Code");
				zip = InputUtils.strInput();
				System.out.println("Enter Phone Number");
				phone = InputUtils.strInput();

				System.out.println(contactListMap.get(addressBookName));
				exitEntry(addressBookName, firstName, lastName, address, city, state, email, zip, phone);
			}
		} else {
			System.out.println("Enter Address Book Name");
			addressBookName = InputUtils.strInput();
			System.out.println("Enter First Name");
			firstName = InputUtils.strInput();
			System.out.println("Enter Last Name");
			lastName = InputUtils.strInput();
			System.out.println("Enter Address");
			address = InputUtils.strInput();
			System.out.println("Enter City Name");
			city = InputUtils.strInput();
			System.out.println("Enter State Name");
			state = InputUtils.strInput();
			System.out.println("Enter Email");
			email = InputUtils.strInput();
			System.out.println("Enter Zip Code");
			zip = InputUtils.strInput();
			System.out.println("Enter Phone Number");
			phone = InputUtils.strInput();

			newEntry(addressBookName, firstName, lastName, address, city, state, email, zip, phone);
		}
	}

	@Override
	public void editContact() {

		System.out.println("List Address Book Name");
		for (HashMap.Entry item : contactListMap.entrySet()) {
			System.out.println(item.getKey());
		}
		System.out.println();
		System.out.println("Enter Address Book Name");
		addressBookName = InputUtils.strInput();
		addressBook = new ArrayList<ContactDetails>();
		addressBook = contactListMap.get(addressBookName);
		System.out.println(addressBook);
		System.out.println("Enter the Username");
		String searchName = InputUtils.strInput();
		int count = 0;
		for (ContactDetails user : addressBook) {
			count++;
			if (user.getFname() != null && user.getFname().contains(searchName)) {
				count = count - 1;
				System.out.println(user.toString());
				System.out.println("Enter changes or the same details.");
				System.out.println("First Name is '" + user.getFname() + "' Edit");
				firstName = InputUtils.strInput();
				System.out.println("Second Name is '" + user.getLname() + "' Edit");
				lastName = InputUtils.strInput();
				System.out.println("Address is '" + user.getAddress() + "' Edit");
				address = InputUtils.strInput();
				System.out.println("City Name is '" + user.getCity() + "' Edit");
				city = InputUtils.strInput();
				System.out.println("State Name is '" + user.getState() + "' Edit");
				state = InputUtils.strInput();
				System.out.println("Email is '" + user.getEmail() + "' Edit");
				email = InputUtils.strInput();
				System.out.println("Zip Code is '" + user.getZip() + "' Edit");
				zip = InputUtils.strInput();
				System.out.println("Phone Number is '" + user.getPhone() + "' Edit");
				phone = InputUtils.strInput();

				contactDetails = new ContactDetails();
				contactDetails.setAddressBookName(addressBookName);
				contactDetails.setFname(firstName);
				contactDetails.setLname(lastName);
				contactDetails.setAddress(address);
				contactDetails.setCity(city);
				contactDetails.setState(state);
				contactDetails.setEmail(email);
				contactDetails.setZip(zip);
				contactDetails.setPhone(phone);

				addressBook.set(count, contactDetails);
				contactListMap.put(addressBookName, addressBook);
				System.out.println("HashMap\n" + contactListMap);
			}
		}
	}

	@Override
	public void deleteContact() {

		System.out.println("List Address Book Name");
		for (HashMap.Entry item : contactListMap.entrySet()) {
			System.out.println(item.getKey());
		}
		System.out.println();
		System.out.println("Enter Address Book Name");
		addressBookName = InputUtils.strInput();
		addressBook = new ArrayList<ContactDetails>();
		addressBook = contactListMap.get(addressBookName);
		System.out.println("List Of Person Name");
		for (ContactDetails i : addressBook) {
			System.out.println(i.getFname() + " ");
		}
		System.out.println();
		System.out.print("Enter the name of the person you want to delete");
		String searchName = InputUtils.strInput();
		int count = 0;
		for (ContactDetails user : addressBook) {
			count++;
			if (user.getFname() != null && user.getFname().contains(searchName)) {
				count = count - 1;
				addressBook.remove(count);
				break;
			}
		}
		contactListMap.put(addressBookName, addressBook);
	}

	@Override
	public void displayAddressBook() {
		System.out.println("\n**Contact Details**");

		System.out.println("List Address Book Name");
		for (HashMap.Entry item : contactListMap.entrySet()) {
			System.out.println(item.getKey());
		}
		System.out.println();
		System.out.println("Enter Address Book Name");
		addressBookName = InputUtils.strInput();
		addressBook = new ArrayList<ContactDetails>();
		addressBook = contactListMap.get(addressBookName);

		for (int i = 0; i < addressBook.size(); i++) {
			contactDetails = addressBook.get(i);
			System.out.println("\nFirst Name: " + contactDetails.getFname() + "\n" + "Last Name: "
					+ contactDetails.getLname() + "\n" + "Address: " + contactDetails.getAddress() + "\n" + "City: "
					+ contactDetails.getCity() + "\n" + "State: " + contactDetails.getState() + "\n" + "Zip Code: "
					+ contactDetails.getZip() + "\n" + "Phone Number: " + contactDetails.getPhone() + "\n"
					+ "Email id: " + contactDetails.getEmail());
		}
	}
}
