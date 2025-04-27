package regex;

import java.util.Scanner;

public class licenceplate {
	public static boolean isvalid(String username) {
		return username.matches("^[A-Z]{2}\\d{4}$");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Licence Plate Number : ");
		String username = input.nextLine();
		if (isvalid(username)) {
			System.out.println("Valid Licence Plate");
		}else {
			System.out.println("Invalid Licence Plate");
		}
	}
}
