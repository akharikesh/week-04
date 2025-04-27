package exception;

import java.util.*;

public class uncheckedexceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("Enter the numerator");
			int n = input.nextInt();
			System.out.println("Enter the denomenator");
			int d = input.nextInt();
			int result = n/d;
			System.out.println("Result : " + result);
		}catch(ArithmeticException e) {
			System.out.println("Cannot divide by zero");
		}catch(InputMismatchException e) {
			System.out.println("Enter a valid number");
		}finally {
			input.close();
		}
	}

}
