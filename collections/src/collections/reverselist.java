package collections;

import java.util.*;

public class reverselist{
	public static  void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		List<Integer> arraylist = new ArrayList<>();
		List<Integer> linkedlist = new LinkedList<>();
		
		System.out.println("Enter the Integers : ");
		for (int i=0;i<n;i++){
			int val = input.nextInt();
			arraylist.add(val);
			linkedlist.add(val);
		}
		Collections.reverse(arraylist);
		Collections.reverse(linkedlist);
		
		System.out.println("Reversed Arraylist : " + arraylist);
		System.out.println("Reversed Linkedlist : " + linkedlist);
		input.close();
	}
}