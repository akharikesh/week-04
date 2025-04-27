package streams;

import java.io.*;

public class uppertolowercase {
    public static void main(String[] args) {
        String inputFile = "input.txt";       
        String outputFile = "output.txt";    

        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile), "UTF-8")
            );
            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8")
            )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("File converted successfully from uppercase to lowercase.");

        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }
}

