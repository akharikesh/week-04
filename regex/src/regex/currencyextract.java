package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class currencyextract {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "The price is $45.99, and the discount is 10.50.";
		Pattern pattern = Pattern.compile("\\$?\\d+\\.\\d{2}");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
