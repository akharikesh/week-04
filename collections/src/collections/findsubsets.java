package collections;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class findsubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		System.out.println("Enter the number of elements in set 1 : ");
		int n1 = input.nextInt();
		input.nextLine();
		System.out.println("Enter the elements in set 1 : ");
		for (int i=0;i<n1;i++) {
			set1.add(input.nextInt());
		}
		System.out.println("Enter the number of elements in set 2 : ");
		int n2 = input.nextInt();
		input.nextLine();
		System.out.println("Enter the elements in set 2 : ");
		for (int i=0;i<n2;i++) {
			set2.add(input.nextInt());
		}
		boolean issubset = set2.containsAll(set1);
		System.out.println("Is set1 a subset of set2? " + issubset);
		input.close();
	}

}
