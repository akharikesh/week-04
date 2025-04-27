package collections;

import java.util.*;

public class nthfromend {
	public static String findnth (LinkedList<String> list, int n){
		if (n<=0 || n>list.size()) {
			return null;
		}
		return list.get(list.size()-n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		LinkedList<String> list = new LinkedList<>();
		System.out.println("Enter the  number of elements");
		int n = input.nextInt();
		input.nextLine();
		System.out.println("Enter the elements : ");
		for (int i=0;i<n;i++) {
			list.add(input.nextLine());
		}
		System.out.println("Enter the value to find ");
		int index = input.nextInt();
		
		String result = findnth(list, index);
		if (result!=null) {
			System.out.println("Nth element from the end is : " + result);
		}else {
			System.out.println("Invalid Input");
		}
		input.close();
	}

}
