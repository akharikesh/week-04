package collections;

import java.util.*;

public class settosortedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		System.out.println("Enter the number of elements : ");
		int n = input.nextInt();
		input.nextLine();
		System.out.println("Enter the elements in set : ");
		for (int i=0;i<n;i++) {
			set.add(input.nextInt());
		}
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		System.out.println("Sorted list : " + list);
		input.close();
	}

}
