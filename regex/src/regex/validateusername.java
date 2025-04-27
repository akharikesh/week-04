package regex;

import java.util.*;

public class validateusername {
	public static boolean isvalid(String username) {
		return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Username : ");
		String username = input.nextLine();
		if (isvalid(username)) {
			System.out.println("Valid Username");
		}else {
			System.out.println("Invalid Username");
		}
	}

}
