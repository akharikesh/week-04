package collections;

import java.io.*;
import java.util.*;

public class wordfrequencycount {
	public static void main(String[] args) {
        String fileName = "input.txt";


        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {

                line = line.toLowerCase().replaceAll("[^a-z0-9\\s]", "");

                String[] words = line.split("\\s+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            System.out.println("Word Frequencies:");
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
