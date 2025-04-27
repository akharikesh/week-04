import java.util.*;

abstract class coursetype{
	abstract String getevaluation();
}
class examcourse extends coursetype{
	public String getevaluation(){
		return "Exam-Based Evaluation";
	}
}
class assignmentcourse extends coursetype{
	public String getevaluation(){
		return "Assignment-Based Evaluation";
	}
}
class researchcourse extends coursetype{
	public String getevaluation(){
		return "Research-Based Evaluation";
	}
}
class course<T extends coursetype>{
	private String coursename;
	private T coursety;
	
	public course(String coursename, T coursety){
		this.coursename = coursename;
		this.coursety = coursety;
	}
	public void display(){
		System.out.println("Course : " + coursename);
		System.out.println("Evaluation Method :" + coursety.getevaluation());
	}
	public T getcourse(){
		return coursety;
	}
}
class utils{
	public static void displayall(List<? extends coursetype> coursetypes){
		for (coursetype ct : coursetypes){
			System.out.println("Evaluation : " + ct.getevaluation());
		}
	}
}
class universitycourse{
	public static void main(String[] args){
		course<examcourse> math = new course<>("Mathematics", new examcourse());
		course<assignmentcourse> literature = new course<>("Literature", new assignmentcourse());
		course<researchcourse> thesis = new course<>("Thesis Writing", new researchcourse());
		math.display();
		System.out.println();
		literature.display();
		System.out.println();
		thesis.display();
		System.out.println();
		List<coursetype> allcourse = new ArrayList<>();
		allcourse.add(new examcourse());
		allcourse.add(new assignmentcourse());
		allcourse.add(new researchcourse());
		System.out.println("----All Course Evaluation----");
		utils.displayall(allcourse);
	}
}