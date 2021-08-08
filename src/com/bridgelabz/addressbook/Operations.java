package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operations implements ContactInterface {

	ContactDetails person;
	static final Scanner input = new Scanner(System.in);
	static List<ContactDetails> addressbook = new ArrayList<ContactDetails>();

	@Override
	public void addNewContact() {

		person = new ContactDetails();
		System.out.print("\nEnter First name: ");
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
	}

	@Override
	public void editContact() {
		System.out.print("Enter the first Name of the Person: ");
		String searchName = input.next();
		int count = 0;
		for (ContactDetails user : addressbook) {
			count++;
			if (user.getFname() != null && user.getFname().contains(searchName)) {
				count = count - 1;
				System.out.println(user.toString());
				System.out.println("Please enter the changes");

				System.out.print("First Name is '" + user.getFname() + "' Edit: ");
				user.setFname(input.next());

				System.out.print("Last Name is '" + user.getLname() + "' Edit: ");
				user.setLname(input.next());

				System.out.print("Address is '" + user.getAddress() + "' Edit: ");
				user.setAddress(input.next());

				System.out.print("City Name is '" + user.getCity() + "' Edit: ");
				user.setCity(input.next());

				System.out.print("State Name is '" + user.getState() + "' Edit: ");
				user.setState(input.next());

				System.out.print("Zip Code is '" + user.getZip() + "' Edit: ");
				user.setZip(input.next());

				System.out.print("Phone Number is '" + user.getPhone() + "' Edit: ");
				user.setPhone(input.next());

				System.out.print("Email is '" + user.getEmail() + "' Edit: ");
				user.setEmail(input.next());
				person = user;
				person = new ContactDetails();
				addressbook.set(count, person);

				break;
			}
		}
	}

	@Override
	public void deleteContact() {
		System.out.print("Enter the name of the person you want to delete: ");
		String name = input.nextLine();
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
