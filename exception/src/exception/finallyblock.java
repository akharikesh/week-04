package exception;

import java.util.Scanner;

public class finallyblock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		try {
			int numerator = input.nextInt();
			int denomenator = input.nextInt();
			int result = numerator/denomenator;
			System.out.println("Result : " + result);
			}catch(ArithmeticException e) {
				System.out.println("Error: Cannot divide by zero");
			}finally {
				System.out.println("Operation Completed");
				input.close();
			}
	}

}
