package regex;

import java.util.*;

public class censorbadwords {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input  =  new Scanner(System.in);
		List<String> badwords  = Arrays.asList("damn","stupid","idiot");
		System.out.println("Enter the sentence");
		String text = input.nextLine();
		for (String badword : badwords) {
			text =  text.replaceAll("(?i)\\b" + badword + "\\b", "****");
		}
		System.out.println(text);
	}
}
