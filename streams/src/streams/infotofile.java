package streams;

import java.io.*;

public class infotofile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader reader = null;
		FileWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your name : ");
			String name = reader.readLine();
			System.out.println("Enter your age : ");
			String age = reader.readLine();
			System.out.println("Enter your favourite programming language : ");
			String language = reader.readLine();
			writer = new FileWriter("C:\\\\full stack web\\\\third.txt");
			writer.write("Name : " + name + "\n");
			writer.write("Age : " + age + "\n");
			writer.write("Favourite Programming Language : " + language + "\n");
			System.out.println("Information Successfully Saved");
		}catch (IOException e) {
			System.out.println("An Error occured" + e.getMessage());
		}finally {
			try {
				if (reader!=null) reader.close();
				if (writer!=null) writer.close();
			}catch (IOException ex) {
				System.out.println("Error Closing" + ex.getMessage());
			}
		}
	}

}
