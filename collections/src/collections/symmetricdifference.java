package collections;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class symmetricdifference {

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
		Set<Integer> union = new HashSet<>(set1);
		union.addAll(set2);
		Set<Integer> intersection = new HashSet<>(set1);
		intersection.retainAll(set2);
		union.removeAll(intersection);
		System.out.println("Symmetric Difference : " + union);
		input.close();
	}

}
