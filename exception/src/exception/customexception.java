package exception;

import java.util.*;

class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
		super(message);
	}
}
public class customexception {
	public static void validage(int age) throws InvalidAgeException{ 
		if (age<18) {
			System.out.println("Age must be above 18");
		}else {
			System.out.println("Access Granted");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("Enter the age");
			int age = input.nextInt();
			validage(age);
			}catch(InvalidAgeException e) {
				System.out.println(e.getMessage());
			}catch(Exception e) {
				System.out.println("Invalid Input");
			}finally {
				input.close();
			}
	}

}
