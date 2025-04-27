package exception;

import java.util.Scanner;

public class nestedtrycatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[] num = {10,45,30,20,15};
		try {
			System.out.println("Enter the index: ");
			int index = input.nextInt();
			try {
				System.out.println("Enter the divisor: ");
				int divisor = input.nextInt();
				int result = num[index]/divisor;
				System.out.println("Result: " +result);
			}catch(ArithmeticException e) {
				System.out.println("Cannot divide by zero");
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid array index");
		}finally {
			System.out.println("Operation completed");
			input.close();
		}
	}

}
