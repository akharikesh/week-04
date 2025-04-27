package streams;

import java.io.*;
import java.util.*;

public class wordcount {
    public static void main(String[] args) {
        String filePath = "";
        
        Map<String, Integer> wordCountMap = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase(); 
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
            
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));  
        
        System.out.println("Top 5 most frequent words:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedList) {
            if (count < 5) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                count++;
            } else {
                break;
            }
        }
    }
}

