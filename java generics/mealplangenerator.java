import java.util.*;

interface mealplan{
	String getmealdescrip();
}
class vegetarianmeal implements mealplan{
	public String getmealdescrip(){
		return "Vegetarian Meal : includes vegetables, fruits, grains etc";
	}
}
class veganmeal implements mealplan{
	public String getmealdescrip(){
		return "Vegan Meal : includes only plant based ingradients";
	}
}
class ketomeal implements mealplan{
	public String getmealdescrip(){
		return "Keto Meal : includes low carbs, high fat ";
	}
}
class highproteinmeal implements mealplan{
	public String getmealdescrip(){
		return "High Protein Meal : rich in lean meats, eggs etc ";
	}
}
class meal<T extends mealplan>{
	private T mealtype;
	
	public meal(T mealtype){
		this.mealtype = mealtype;
	}
	public void showmeal(){
	System.out.println(mealtype.getmealdescrip());
	}
	public T getmealplan(){
		return mealtype;
	}
}
class mealplangen{
	public static <T extends mealplan> meal<T> generateplan(T mealtype){
		System.out.println("Generate personalized meal plan ");
		return new meal<>(mealtype);
	}
}
class mealplangenerator{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Choose your meal type");
		System.out.println("1. vegetarian\n2. vegan\n3. keto\n4. high protein");
		int choice = input.nextInt();
		
		meal<? extends mealplan> meal = null;
		
		switch(choice){
			case 1 :
			meal = mealplangen.generateplan(new vegetarianmeal());
			break;
			case 2 :
			meal = mealplangen.generateplan(new veganmeal());
			break;
			case 3 :
			meal = mealplangen.generateplan(new ketomeal());
			break;
			case 4 :
			meal = mealplangen.generateplan(new highproteinmeal());
			break;
			default : 
			System.out.println("Invalid Choice");
			return;
		}
		System.out.println("---Your Meal Plan----");
		meal.showmeal();
	}
}