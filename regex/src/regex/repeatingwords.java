package regex;

import java.util.*;
import java.util.regex.*;

public class repeatingwords {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "This is is a repeated repeated word test";
		Pattern pattern = Pattern.compile("\\b(\\w+)\\b\\s+\\1\\b", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);
		Set<String> duplicates = new LinkedHashSet<>();
		while (matcher.find()) {
			duplicates.add(matcher.group(1));
		}
		System.out.println("Repeated words : " + String.join(", ", duplicates));
	}
}

