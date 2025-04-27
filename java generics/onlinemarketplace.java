import java.util.*;

abstract class category{
	private String name;
	
	public category(String name){
		this.name=name;
	}
	public String getname(){
		return name;
	}
}
class bookcategory extends category{
	public bookcategory(String name){
		super(name);
	}
}
class clothingcategory extends category{
	public clothingcategory(String name){
		super(name);
	}
}
class gadgetscategory extends category{
	public gadgetscategory(String name){
		super(name);
	}
}
class product<T extends category>{
	private String name;
	private double price;
	private T categor;
	public product(String name, double price, T categor){
		this.name=name;
		this.price=price;
		this.categor=categor;
	}
	public void discount(double percent){
		price -= price*(percent/100);
	}
	public void display(){
		System.out.printf("Product: %-10s  Category: %-12s   Price: %.2f\n", name, categor.getname(), price);
	}
}
public class onlinemarketplace{
	public static <T extends category> void discount(product<T> prod, double percentage){
		prod.discount(percentage);
		System.out.println("Discount Applied : " + percentage);
	}
	public static void main(String[] args){
		bookcategory horror = new bookcategory("Horror");
		clothingcategory mens = new clothingcategory("Mens");
		gadgetscategory laptop = new gadgetscategory("Laptop");
		product<bookcategory> book = new product<>("IT",600,horror);
		product<clothingcategory> shirt = new product<>("T-shirt",350,mens);
		product<gadgetscategory> lap = new product<>("Macbook", 24000, laptop);
		List<product<? extends category>> catalog = new ArrayList<>();
		catalog.add(book);
		catalog.add(shirt);
		catalog.add(lap);
		System.out.println("----marketplace catalog-----");
		for (product<? extends category> p : catalog){
			p.display();
		}
		System.out.println("\n-----applying discounts-----");
		discount(book, 20);
		discount(shirt, 15);
		discount(lap, 35);
		System.out.println("----updated catalog-----");
		for (product<? extends category> p : catalog){
			p.display();
		}
	}
}
