package regex;

import java.util.*;
import java.util.regex.*;

public class validateSSN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the SSN : ");
		String ssn = input.nextLine();
		Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");
		Matcher matcher = pattern.matcher(ssn);
		boolean found = false;
		while (matcher.find()) {
			System.out.println(matcher.group() + " is valid");
			found = true;
		}
		if (!found) {
			System.out.println("No valid SSN found");
		}
		
	}

}
