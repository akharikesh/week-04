package regex;

import java.util.regex.*;

public class extractcapitalizedwords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
		Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
