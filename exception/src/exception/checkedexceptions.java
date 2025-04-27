package exception;

import java.io.*;

public class checkedexceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader reader = new BufferedReader(new FileReader("C:\\full stack web\\third.txt"))){	
			String line;
			while((line= reader.readLine())!=null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			System.out.println("File not found");
		}
	}

}
