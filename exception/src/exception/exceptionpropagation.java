package exception;

public class exceptionpropagation {
	static void method1() {
		int result = 10/0;
	}
	static void method2() {
		method1();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			method2();
		}catch(ArithmeticException e) {
			System.out.println("Handled exception in main");
		}
	}

}
