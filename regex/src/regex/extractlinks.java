package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class extractlinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Visit https://www.google.com and http://example.org for more info.";
		Pattern pattern = Pattern.compile("https?://[\\w.-]+(?:\\.[\\w.-]+)+(?:/[\\w./?%&=-]*)?");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
