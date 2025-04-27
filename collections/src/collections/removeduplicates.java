package collections;

import java.util.*;

public class removeduplicates {
	public static List<Integer> remove(List<Integer> list){
		Set<Integer> dupe = new HashSet<>(list);
		return new ArrayList<>(dupe);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		System.out.println("Enetr the number of elements");
		int n = input.nextInt();
		System.out.println("Enter the elements : ");
		for(int i=0;i<n;i++) {
			list.add(input.nextInt());
		}
		List<Integer> result = remove(list);
		System.out.println("List after removing duplicates : " + result);
		input.close();
		// TODO Auto-generated method stub
	}

}
