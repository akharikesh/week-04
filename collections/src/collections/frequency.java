package collections;

import java.util.*;

public class frequency {
    public static Map<String, Integer> countFrequencies(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String str : list) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = input.nextInt();
        input.nextLine(); 

        List<String> inputList = new ArrayList<>();
        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            inputList.add(input.nextLine());
        }

        Map<String, Integer> frequencies = countFrequencies(inputList);

        System.out.println("Frequency of elements:");
        for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        input.close();
    }
}
