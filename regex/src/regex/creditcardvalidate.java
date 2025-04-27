package regex;

import java.util.*;

public class creditcardvalidate {
	public static boolean isvalidvisa(String num) {
		return num.matches("^4\\d{15}$");
	}
	public static boolean isvalidmaster(String num) {
		return num.matches("^5\\d{15}$");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String cardnum =  input.nextLine().trim();
		if (isvalidvisa(cardnum)) {
			System.out.println("Valid visa card");
		}else  if (isvalidmaster(cardnum)) {
			System.out.println("Valid master card");
		}else {
			System.out.println("Invalid card number");
		}
	}

}
