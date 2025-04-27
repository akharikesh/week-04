package exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class trywithresources {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader reader = new BufferedReader(new FileReader("C:\\full stack web\\third.txt"))){	
			String line = reader.readLine();
			if(line!=null){
				System.out.println("First Line : " + line);
			}else {
				System.out.println("File is empty");
			}
		}catch(IOException e) {
			System.out.println("Error reading file");
		}
	}

}
