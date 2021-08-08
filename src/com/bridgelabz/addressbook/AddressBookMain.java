package com.bridgelabz.addressbook;

public class AddressBookMain {
	static ContactInterface c = new Operations();

	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book Program!");
		int option = 0;
		while (option != 10) {
			System.out.println("\n" + "1.Add Contact" + "\n" + "2.Display Contacts" + "\n" + "3.Edit Contact" + "\n"
					+ "4.Delete Contact" + "\n" + "10. Exit");
			System.out.print("Enter option: ");
			option = InputUtils.intInput();

			switch (option) {
			case 1:
				char isContinue = 'n';
				do {
					c.addNewContact();
					System.out.println("Contact added successfully.");
					System.out.println("Do you want to add anoher contact (y/n): ");
					isContinue = InputUtils.charInput();
				}

				while (isContinue == 'y' || isContinue == 'Y');
				break;
			case 2:
				c.displayAddressBook();
				break;
			case 3:
				c.editContact();
				break;
			case 4:
				c.deleteContact();
				break;
			case 10:
				break;
			default:
				System.out.println("Enter from the options!");
			}
		}
	}
}
