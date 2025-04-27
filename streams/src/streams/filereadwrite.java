package streams;

import java.io.*;

public class filereadwrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sourcefile = "C:\\\\full stack web\\exaple.txt";
		String destinationfile = "C:\\full stack web\\third.txt";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			File inputfile =  new File(sourcefile);
			if(!inputfile.exists()) {
				System.out.println("Source file does not exist");
				return;
			}
			fis = new FileInputStream(inputfile);
			fos = new FileOutputStream(destinationfile);
			int data;
			while ((data = fis.read())!=-1) {
				fos.write(data);
			}
			System.out.println("File copied succesfully");
		} catch (IOException e) {
			System.out.println("An Error occured : " + e.getMessage());
		}finally {
			try {
				if (fis!=null) fis.close();
				if (fos!=null) fos.close();
			}catch (IOException e) {
				System.out.println("Error closing streams : " + e.getMessage());
			}
		}
	}
}

