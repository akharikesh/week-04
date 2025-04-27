package regex;

import java.util.Scanner;

public class hexcolor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the hex color code: ");
		String code = input.nextLine();
		if (code.matches("^#[0-9A-Fa-f]{6}$")) {
			System.out.println("Valid hex color code");
		}else {
			System.out.println("Invalid hex color code");
		}
	}

}
