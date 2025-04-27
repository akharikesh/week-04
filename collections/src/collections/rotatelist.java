package collections;

import java.util.*;

public class rotatelist {
	public static <T> void rotate (List<T> list, int pos) {
		int size = list.size();
		if(size==0 || pos%size==0) return;
		pos = pos%size;
		List<T> rotated = new ArrayList<>();
		rotated.addAll(list.subList(pos, size));
		rotated.addAll(list.subList(0, pos));
		
		for (int i=0;i<size;i++) {
			list.set(i, rotated.get(i));
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the elements");
		int n = input.nextInt();
		List<Integer> list = new ArrayList<>();
		System.out.println("Enter Elements");
		for (int i=0;i<n;i++) {
			list.add(input.nextInt());
		}
		System.out.println("Enter the number of positions to rotate");
		int pos = input.nextInt();
		
		rotate(list, pos);
		
		System.out.println("Rotated List : " + list);
	}
}
