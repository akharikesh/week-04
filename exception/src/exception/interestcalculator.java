package exception;

public class interestcalculator {
	public static double calculateInterest(double amount, double rate, int years) {
		if (amount < 0 || rate < 0) {
			throw new IllegalArgumentException("Amount and Rate must be positive");
		}
		return amount*rate*years/100;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			double interest =  calculateInterest(1000, 5, 3);
			System.out.println("Calculated Interest : " + interest);
			interest = calculateInterest(-500, 4, 5);
			System.out.println("Calculated Interest : " + interest);
		}catch (IllegalArgumentException e) {
			System.out.println("Invalid input");
		}
	}

}
