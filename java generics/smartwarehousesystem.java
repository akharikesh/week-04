import java.util.*;

abstract class warehouseitem{
	private String name;
	
	public warehouseitem(String name){
		this.name=name;
	}
	public String getname(){
		return name;
	}
	public abstract void details();
}
class electronics extends warehouseitem{
	public electronics(String name){
		super(name);
	}
	public void details(){
		System.out.println("Electronic Items : " + getname());
	}
}
class groceries extends warehouseitem{
	public groceries(String name){
		super(name);
	}
	public void details(){
		System.out.println("Groceries Items : " + getname());
	}
}
class furniture extends warehouseitem{
	public furniture(String name){
		super(name);
	}
	public void details(){
		System.out.println("Furniture Items : " + getname());
	}
}
class storage<T extends warehouseitem>{
	private List<T> items = new ArrayList<>();
	public void additem(T item){
		items.add(item);
	}
	public List<T> getitems(){
		return items;
	}
}
class utils{
	public static void display(List<? extends warehouseitem> items){
		for (warehouseitem item : items){
			item.details();
		}
	}
}
class smartwarehousesystem{
	public static void main(String[] args){
		storage<electronics> estorage = new storage<>();
		estorage.additem(new electronics("Headphone"));
		estorage.additem(new electronics("Phone"));
		storage<groceries> gstorage = new storage<>();
		gstorage.additem(new groceries("Curd"));
		gstorage.additem(new groceries("Lemon"));
		storage<furniture> fstorage = new storage<>();
		fstorage.additem(new furniture("Table"));
		fstorage.additem(new furniture("Chair"));
		System.out.println("Displaying Electronics : ");
		utils.display(estorage.getitems());
		System.out.println("\nDisplaying Groceries : ");
		utils.display(gstorage.getitems());
		System.out.println("\nDisplaying Furniture : ");
		utils.display(fstorage.getitems());
	}
}

