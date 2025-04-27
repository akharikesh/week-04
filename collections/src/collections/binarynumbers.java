package collections;

import java.util.*;


public class binarynumbers {
	public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 0; i < N; i++) {
            String current = queue.poll();
            result.add(current);

            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();

        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println("Binary Numbers: " + binaryNumbers);

        scanner.close();
    }
}
