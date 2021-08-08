package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
	static final Scanner input = new Scanner(System.in);
	static ArrayList<ContactDetails> addressbook = new ArrayList<ContactDetails>();
	static ContactDetails person = new ContactDetails();

	public void addNewContact() {

		System.out.print("Enter First name: ");
		person.setFname(input.nextLine());

		System.out.print("Enter Last name: ");
		person.setLname(input.nextLine());

		System.out.print("Enter Address: ");
		person.setAddress(input.nextLine());

		System.out.print("Enter City: ");
		person.setCity(input.nextLine());

		System.out.print("Enter State: ");
		person.setState(input.nextLine());

		System.out.print("Enter Zip Code: ");
		person.setZip(input.nextLine());

		System.out.print("Enter Phone number: ");
		person.setPhone(input.nextLine());

		System.out.print("Enter Email id: ");
		person.setEmail(input.nextLine());

		addressbook.add(person);
		System.out.println("Contact added successfully.");
	}

	public void displayAddressBook() {
		System.out.println("\n**Contact Details**");
		for (int i = 0; i < addressbook.size(); i++) {
			ContactDetails person = addressbook.get(i);
			System.out.println("\nFirst Name: " + person.getFname() + "\n" + "Last Name: " + person.getLname() + "\n"
					+ "Address: " + person.getAddress() + "\n" + "City: " + person.getCity() + "\n" + "State: "
					+ person.getState() + "\n" + "Zip Code: " + person.getZip() + "\n" + "Phone Number: "
					+ person.getPhone() + "\n" + "Email id: " + person.getEmail());
		}
	}

	public void editContact() {
		System.out.print("Enter the first Name of the Person: ");
		String editName = input.nextLine();
		if (editName.equalsIgnoreCase(person.getFname())) {
			addNewContact();
		} else {
			System.out.println("The name does not match the AddressBook");
			System.out.println("Please enter valid First Name");
			editContact();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book Program!");
		AddressBookMain m = new AddressBookMain();
		m.addNewContact();
		m.displayAddressBook();
		m.editContact();
		m.displayAddressBook();
	}
}
