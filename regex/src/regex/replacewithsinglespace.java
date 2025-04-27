package regex;

public class replacewithsinglespace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "This  is an  example with  multiple spaces.";
		String result =  text.replaceAll("\\s{2,}"," ");
		System.out.println(result);
	}

}
