package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;

public class Operations implements ContactInterface {

	ContactDetails person;
	static List<ContactDetails> addressbook = new ArrayList<ContactDetails>();

	@Override
	public void addNewContact() {

		person = new ContactDetails();
		System.out.print("\nEnter First name: ");
		person.setFname(InputUtils.strInput());

		System.out.print("Enter Last name: ");
		person.setLname(InputUtils.strInput());

		System.out.print("Enter Address: ");
		person.setAddress(InputUtils.strInput());

		System.out.print("Enter City: ");
		person.setCity(InputUtils.strInput());

		System.out.print("Enter State: ");
		person.setState(InputUtils.strInput());

		System.out.print("Enter Zip Code: ");
		person.setZip(InputUtils.strInput());

		System.out.print("Enter Phone number: ");
		person.setPhone(InputUtils.strInput());

		System.out.print("Enter Email id: ");
		person.setEmail(InputUtils.strInput());

		addressbook.add(person);
	}

	@Override
	public void editContact() {
		System.out.print("Enter the first Name of the Person: ");
		String searchName = InputUtils.strInput();
		int count = 0;
		for (ContactDetails person : addressbook) {
			count++;
			if (person.getFname() != null && person.getFname().contains(searchName)) {
				count = count - 1;
				System.out.println(person.toString());
				System.out.println("Please enter the changes");

				System.out.print("First Name is '" + person.getFname() + "' Edit: ");
				person.setFname(InputUtils.strInput());

				System.out.print("Last Name is '" + person.getLname() + "' Edit: ");
				person.setLname(InputUtils.strInput());

				System.out.print("Address is '" + person.getAddress() + "' Edit: ");
				person.setAddress(InputUtils.strInput());

				System.out.print("City Name is '" + person.getCity() + "' Edit: ");
				person.setCity(InputUtils.strInput());

				System.out.print("State Name is '" + person.getState() + "' Edit: ");
				person.setState(InputUtils.strInput());

				System.out.print("Zip Code is '" + person.getZip() + "' Edit: ");
				person.setZip(InputUtils.strInput());

				System.out.print("Phone Number is '" + person.getPhone() + "' Edit: ");
				person.setPhone(InputUtils.strInput());

				System.out.print("Email is '" + person.getEmail() + "' Edit: ");
				person.setEmail(InputUtils.strInput());

				person = new ContactDetails();
				addressbook.set(count, person);

				break;
			}
		}
	}

	@Override
	public void deleteContact() {
		System.out.print("Enter the name of the person you want to delete: ");
		String name = InputUtils.strInput();
		for (int i = 0; i < addressbook.size(); i++) {
			if (addressbook.get(i).getFname().equals(name)) {
				person = addressbook.get(i);
				addressbook.remove(person);
			}
		}
	}

	@Override
	public void displayAddressBook() {
		System.out.println("\n**Contact Details**");
		for (int i = 0; i < addressbook.size(); i++) {
			person = addressbook.get(i);
			System.out.println("\nFirst Name: " + person.getFname() + "\n" + "Last Name: " + person.getLname() + "\n"
					+ "Address: " + person.getAddress() + "\n" + "City: " + person.getCity() + "\n" + "State: "
					+ person.getState() + "\n" + "Zip Code: " + person.getZip() + "\n" + "Phone Number: "
					+ person.getPhone() + "\n" + "Email id: " + person.getEmail());
		}
	}
}
