package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class qextractdates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
		Pattern pattern = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
