package regex;

import java.util.*;
import java.util.regex.*;

public class extractlanguagenames {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
		List<String> languages  = Arrays.asList("Java", "Python", "JavaScript", "C++", "C#", "Go", "Rust", "Ruby");
		String patternstring = "(?i)\\b(" + String.join("|", languages) + ")\\b";
		Pattern pattern = Pattern.compile(patternstring);
		Matcher matcher = pattern.matcher(text);
		Set<String> found = new LinkedHashSet<>();
		while (matcher.find()) {
			found.add(matcher.group());
		}
		System.out.println(String.join(", ", found));
	}
}
