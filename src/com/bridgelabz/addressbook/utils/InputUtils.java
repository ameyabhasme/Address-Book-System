package com.bridgelabz.addressbook.utils;

import java.util.Scanner;

public class InputUtils {
	static final Scanner input = new Scanner(System.in);
	
	public static int intInput() {
		return input.nextInt();
	}
	
	public static char charInput() {
		return input.next().charAt(0);
	}
	
	public static String strInput() {
		return input.next();
	}
	
	public static String strLineInput() {
		return input.nextLine();
	}
}
