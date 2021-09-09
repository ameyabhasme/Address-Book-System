package com.bridgelabz.addressbook;

import com.bridgelabz.addressbook.service.ContactInterface;
import com.bridgelabz.addressbook.service.impl.Operations;
import com.bridgelabz.addressbook.utils.InputUtils;

public class AddressBookMain {

	static ContactInterface c = new Operations();

	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book Program!");
		int option = 0;
		while (option != 10) {
			System.out.println("\n" + "1. Add Contact" + "\n" + "2. Edit Contact" + "\n" + "3. Delete Contact" + "\n"
					+ "4. Display Contact" + "\n" + "5. Search" + "\n" + "10. Exit");
			System.out.print("Enter option: ");
			option = InputUtils.intInput();

			switch (option) {
			case 1:
					c.addContact();
//					c.defaultEntry();
					System.out.println("Contact added successfully.");
				break;
			case 2:
				c.editContact();
				System.out.println("Contact saved!");
				break;
			case 3:
				c.deleteContact();
				System.out.println("Deleted successfully!");
				break;
			case 4:
				c.displayAddressBook();
				break;
			case 5:
				c.searchByCityOrState();
				break;
			case 10:
				break;
			default:
				System.out.println("Enter from the options!");
			}
		}
	}
}

