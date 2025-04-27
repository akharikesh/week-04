package collections;

import java.util.*;

public class reversequeue {
	public static void reverse (Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		while (!queue.isEmpty()) {
			stack.push(queue.remove());
		}
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		System.out.println("Enter the number of elements ");
		int n= input.nextInt();
		System.out.println("Enter the elements");
		for (int i=0;i<n;i++) {
			queue.add(input.nextInt());
		}
		System.out.println("Orginal Queue : " + queue);
		reverse(queue);
		System.out.println("Reversed Queue : " + queue);
		input.close();
	}

}
