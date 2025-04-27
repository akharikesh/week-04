package collections;

import java.util.*;

public class comparesets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		int n = input.nextInt();
		input.nextLine();
		System.out.println("Enter the elements in set 1 : ");
		for (int i=0;i<n;i++) {
			set1.add(input.nextInt());
		}
		System.out.println("Enter the elements in set 2 : ");
		for (int i=0;i<n;i++) {
			set2.add(input.nextInt());
		}
		if (set1.equals(set2)) {
			System.out.println("The two sets are equal");
		}else {
			System.out.println("Sets are not equal");
		}
		input.close();
	}

}
