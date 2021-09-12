package com.bridgelabz.addressbook.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.bridgelabz.addressbook.dto.ContactDetails;
import com.bridgelabz.addressbook.service.ContactInterface;
import com.bridgelabz.addressbook.utils.InputUtils;

public class Operations implements ContactInterface {

	private static Set<ContactDetails> addressBook;
	public Map<String, Set<ContactDetails>> contactListMap = new HashMap<>();
	public Map<String, Set<ContactDetails>> cityMap = new HashMap<>();
	public Map<String, Set<ContactDetails>> stateMap = new HashMap<>();
	ContactDetails contactDetails;

	@Override
	public void addContact() {

		char option = 'n';
		System.out.println("Do you want to add in existing Address Book?(y/n)");
		option = InputUtils.charInput();

		if (option == 'Y' || option == 'y') {
			if (contactListMap.isEmpty()) {
				System.out.println("It is Empty.");
			} else {
				System.out.println("Address Book Name List");

				for (HashMap.Entry item : contactListMap.entrySet()) {
					System.out.println(item.getKey());
				}
				System.out.println();
				contactDetails = new ContactDetails();
				contactDetails = userDetailsEntry(contactDetails);
				enterDetails(contactDetails);
			}
		} else {
			contactDetails = new ContactDetails();
			contactDetails = userDetailsEntry(contactDetails);
			enterDetails(contactDetails);
		}
		personByCity();
		personByState();
	}

	@Override
	public void editContact() {

		String addressBookName = printAddressBookName();
		addressBook = contactListMap.get(addressBookName);
		System.out.println(addressBook);
		System.out.println("Enter the Username:");
		String searchName = InputUtils.strInput();
		int count = 0;
		for (ContactDetails user : addressBook) {
			count++;
			if (user.getFname() != null && user.getFname().contains(searchName)) {
				count = count - 1;
				System.out.println(user.toString());
				user.setAddressBookName(addressBookName);
				System.out.println("Enter changes or the same details.");
				System.out.println("First Name is '" + user.getFname() + "' Edit");
				user.setFname(InputUtils.strInput());
				System.out.println("Second Name is '" + user.getLname() + "' Edit");
				user.setLname(InputUtils.strInput());
				System.out.println("Address is '" + user.getAddress() + "' Edit");
				user.setAddress(InputUtils.strLineInput());
				System.out.println("City Name is '" + user.getCity() + "' Edit");
				user.setCity(InputUtils.strInput());
				System.out.println("State Name is '" + user.getState() + "' Edit");
				user.setState(InputUtils.strInput());
				System.out.println("Email is '" + user.getEmail() + "' Edit");
				user.setEmail(InputUtils.strInput());
				System.out.println("Zip Code is '" + user.getZip() + "' Edit");
				user.setZip(InputUtils.strInput());
				System.out.println("Phone Number is '" + user.getPhone() + "' Edit");
				user.setPhone(InputUtils.strInput());
			}
		}
	}

	@Override
	public void deleteContact() {

		String addressBookName = printAddressBookName();
		addressBook = contactListMap.get(addressBookName);
		System.out.println("List of Names");

		addressBook.stream().forEach(i -> System.out.println(i.getFname() + " "));
		System.out.println();
		System.out.println("Enter the name of the person you want to delete:");
		String searchName = InputUtils.strInput();
		for (ContactDetails contactDetails : addressBook) {
			if (contactDetails.getFname() != null && contactDetails.getFname().contains(searchName)) {
				addressBook.remove(contactDetails);
				break;
			}
		}
	}

	@Override
	public void display() {
		System.out.println("\n**Contact Details**\n");

		contactListMap.entrySet().stream().forEach(item -> {
			System.out.println(item.getKey() + "\n" + item.getValue());
			System.out.println();
		});
	}

	@Override
	public void searchByCityOrState() {

		int option = 0;
		System.out.println("Choose filter to search:" + "\n" + "1) By State\n2) By City");
		option = InputUtils.intInput();
		switch (option) {
		case 1:
			printStateNames();
			break;
		case 2:
			printCityNames();
			break;
		default:
			System.out.println("Enter valid option!");
		}
	}

	public void printCityNames() {
		Set<String> result = contactListMap.entrySet().stream()
				.flatMap(data -> data.getValue().stream().map(ContactDetails::getCity)).collect(Collectors.toSet());

		System.out.println();
		for (String city : result) {
			System.out.println(city);
		}
		System.out.println("\nEnter City From List:");
		String searchCity = InputUtils.strInput();
		if (result.contains(searchCity)) {
			contactListMap.entrySet().stream().flatMap(data -> data.getValue().stream())
					.filter(data -> data.getCity().equals(searchCity)).forEach(System.out::println);
		} else {
			System.out.println("Sorry, this city is not available.");
		}
	}

	public void printStateNames() {
		Set<String> result = contactListMap.entrySet().stream()
				.flatMap(data -> data.getValue().stream().map(ContactDetails::getState)).collect(Collectors.toSet());

		System.out.println();
		for (String state : result) {
			System.out.println(state);
		}
		System.out.println("\nEnter State From List:");
		String searchState = InputUtils.strInput();
		if (result.contains(searchState)) {
			contactListMap.entrySet().stream().flatMap(data -> data.getValue().stream())
					.filter(data -> data.getState().equals(searchState)).forEach(System.out::println);
		} else {
			System.out.println("Sorry, this state is not available.");
		}
	}

	public Set<ContactDetails> storeInMap(String searchCityState, ContactDetails userContactDetails,
			Map<String, Set<ContactDetails>> map) {
		addressBook = new HashSet<ContactDetails>();
		if (map.get(searchCityState) == null) {
			addressBook.add(userContactDetails);
		} else {
			addressBook = map.get(searchCityState);
			addressBook.add(userContactDetails);
		}
		return addressBook;
	}

	public void personByCity() {
		for (HashMap.Entry item : contactListMap.entrySet()) {
			addressBook = contactListMap.get(item.getKey());
			for (ContactDetails contactDetails : addressBook) {
				addressBook = storeInMap(contactDetails.getCity(), contactDetails, cityMap);
				cityMap.put(contactDetails.getCity(), addressBook);
			}
		}
	}

	@Override
	public void viewPersonByCity() {
		personByCity();
		System.out.println("Person by City");
		cityMap.entrySet().stream().forEach(m -> {
			System.out.print(m.getKey() + " : ");
			m.getValue().forEach(System.out::println);
			System.out.println();
		});
	}

	public void personByState() {
		for (HashMap.Entry m : contactListMap.entrySet()) {
			addressBook = contactListMap.get(m.getKey());
			for (ContactDetails contactDetails : addressBook) {
				addressBook = storeInMap(contactDetails.getState(), contactDetails, stateMap);
				stateMap.put(contactDetails.getState(), addressBook);
			}
		}
	}

	@Override
	public void viewPersonByState() {
		personByState();
		System.out.println("Person by State");
		stateMap.entrySet().stream().forEach(m -> {
			System.out.print(m.getKey() + " : ");
			m.getValue().forEach(System.out::println);
			System.out.println();
		});
	}
	
	@Override
	public void viewCount() {
		personByCity();
		personByState();
		System.out.println("Person by City Count");
		for (HashMap.Entry item : cityMap.entrySet()) {
			addressBook = cityMap.get(item.getKey());
			System.out.println(item.getKey() + " : " + addressBook.size());
		}
		System.out.println("Person by State Count");
		for (HashMap.Entry item : stateMap.entrySet()) {
			addressBook = stateMap.get(item.getKey());
			System.out.println(item.getKey() + " : " + addressBook.size());
		}
	}

	public void enterDetails(ContactDetails contactDetails) {
		addressBook = new HashSet<ContactDetails>();
		if (contactListMap.get(contactDetails.getAddressBookName()) == null) {
			System.out.println("This is New Address Book : " + contactDetails.getAddressBookName());
			addressBook.add(contactDetails);
		} else {
			addressBook = contactListMap.get(contactDetails.getAddressBookName());
			System.out
					.println("You're Adding Contact in Exiting Address Book : " + contactDetails.getAddressBookName());
			addressBook.add(contactDetails);
		}
		contactListMap.put(contactDetails.getAddressBookName(), addressBook);
	}

	public String printAddressBookName() {
		System.out.println("Address Book Name List");
		for (HashMap.Entry item : contactListMap.entrySet()) {
			System.out.println(item.getKey());
		}
		System.out.println();
		System.out.println("Enter Address Book Name");
		String addressBookName = InputUtils.strInput();
		return addressBookName;
	}

	public ContactDetails userDetailsEntry(ContactDetails contactdetails) {

		System.out.println("Enter Address Book Name");
		contactDetails.setAddressBookName(InputUtils.strInput());
		System.out.println("Enter First Name");
		contactDetails.setFname(InputUtils.strInput());
		System.out.println("Enter Last Name");
		contactDetails.setLname(InputUtils.strInput());
		System.out.println("Enter Address");
		contactDetails.setAddress(InputUtils.strInput());
		System.out.println("Enter City Name");
		contactDetails.setCity(InputUtils.strInput());
		System.out.println("Enter State Name");
		contactDetails.setState(InputUtils.strInput());
		System.out.println("Enter Email");
		contactDetails.setEmail(InputUtils.strInput());
		System.out.println("Enter Zip Code");
		contactDetails.setZip(InputUtils.strInput());
		System.out.println("Enter Phone Number");
		contactDetails.setPhone(InputUtils.strInput());

		return contactdetails;
	}

	@Override
	public void defaultEntry() {
		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Family");
		contactDetails.setFname("Ameya");
		contactDetails.setLname("Bhasme");
		contactDetails.setAddress("Mankapur");
		contactDetails.setCity("Pune");
		contactDetails.setState("Maharashtra");
		contactDetails.setEmail("ameya@gmail.com");
		contactDetails.setZip("440030");
		contactDetails.setPhone("9975401899");
		addressBook = new HashSet<ContactDetails>();
		addressBook.add(contactDetails);
		contactListMap.put(contactDetails.getAddressBookName(), addressBook);

		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Family");
		contactDetails.setFname("Narendra");
		contactDetails.setLname("Bhasme");
		contactDetails.setAddress("Mankapur");
		contactDetails.setCity("Indore");
		contactDetails.setState("Maharashtra");
		contactDetails.setEmail("nmbhasme@gmail.com");
		contactDetails.setZip("440030");
		contactDetails.setPhone("9764444803");
		addressBook = new HashSet<ContactDetails>();
		addressBook = contactListMap.get(contactDetails.getAddressBookName());
		addressBook.add(contactDetails);
		contactListMap.put(contactDetails.getAddressBookName(), addressBook);

		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Work");
		contactDetails.setFname("Sahil");
		contactDetails.setLname("Surme");
		contactDetails.setAddress("Kharghar");
		contactDetails.setCity("Mumbai");
		contactDetails.setState("Maharashtra");
		contactDetails.setEmail("sahilsurme@gmail.com");
		contactDetails.setZip("400052");
		contactDetails.setPhone("9858489537");
		addressBook = new HashSet<ContactDetails>();
		addressBook.add(contactDetails);
		contactListMap.put(contactDetails.getAddressBookName(), addressBook);

		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Work");
		contactDetails.setFname("Ritvija");
		contactDetails.setLname("Suham");
		contactDetails.setAddress("Itwari");
		contactDetails.setCity("Pune");
		contactDetails.setState("Maharashtra");
		contactDetails.setEmail("rjsuham@gmail.com");
		contactDetails.setZip("440048");
		contactDetails.setPhone("9589746682");
		addressBook = new HashSet<ContactDetails>();
		addressBook = contactListMap.get(contactDetails.getAddressBookName());
		addressBook.add(contactDetails);
		contactListMap.put(contactDetails.getAddressBookName(), addressBook);

		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Work");
		contactDetails.setFname("Ritvija");
		contactDetails.setLname("Suham");
		contactDetails.setAddress("Itwari");
		contactDetails.setCity("Nagpur");
		contactDetails.setState("Maharashtra");
		contactDetails.setEmail("rjsuham@gmail.com");
		contactDetails.setZip("440048");
		contactDetails.setPhone("9589746682");
		addressBook = new HashSet<ContactDetails>();
		addressBook = contactListMap.get(contactDetails.getAddressBookName());
		addressBook.add(contactDetails);
		contactListMap.put(contactDetails.getAddressBookName(), addressBook);
	}
}
