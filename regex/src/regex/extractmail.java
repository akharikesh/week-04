package regex;

import java.util.*;
import java.util.regex.*;

public class extractmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Contact us at support@example.com and info@company.org";
		Pattern pattern = Pattern.compile("\\\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,6}\\\\b");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
