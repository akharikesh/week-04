package exception;

import java.util.Scanner;

public class multiplecatch {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[] number = null;
		try {
			System.out.println("Enter the index to retrieve");
			int index = input.nextInt();
			int value = number[index];
			System.out.println("value of index " + index + " : " + value);
		}catch(ArrayIndexOutOfBoundsException  e) {
			System.out.println("Invalid Index");
		}catch(NullPointerException  e) {
			System.out.println("Array is not initialized");
		}finally {
			input.close();
		}
	}
}
