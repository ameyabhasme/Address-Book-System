package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
	static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		List<String> person = new ArrayList<String>();
		
		System.out.println("Welcome to the Address Book Program!");

		System.out.print("Enter First name: ");
		String fname = input.nextLine();

		System.out.print("Enter Last name: ");
		String lname = input.nextLine();

		System.out.print("Enter First Address: ");
		String address = input.nextLine();

		System.out.print("Enter City: ");
		String city = input.nextLine();

		System.out.print("Enter State: ");
		String state = input.nextLine();

		System.out.print("Enter Zip Code: ");
		String zip = input.nextLine();

		System.out.println("Enter Phone number: ");
		String phone = input.nextLine();

		person.add(fname);
		person.add(lname);
		person.add(address);
		person.add(city);
		person.add(state);
		person.add(zip);
		person.add(phone);

		for (String str : person) {
			System.out.println(str);
		}

	}
}
