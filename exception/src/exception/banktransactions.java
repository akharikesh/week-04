package exception;

class InsufficientBalanceException extends Exception {
 public InsufficientBalanceException(String message) {
     super(message);
 }
}

class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public void withdraw(double amount) throws InsufficientBalanceException {
     if (amount < 0) {
         throw new IllegalArgumentException("Invalid amount!");
     } else if (amount > balance) {
         throw new InsufficientBalanceException("Insufficient balance!");
     } else {
         balance -= amount;
         System.out.println("Withdrawal successful, new balance: " + balance);
     }
 }

 public double getBalance() {
     return balance;
 }
}


public class banktransactions{
 public static void main(String[] args) {
     BankAccount account = new BankAccount(1000.0);  

     try {
         account.withdraw(200);     
         account.withdraw(-50);     
         account.withdraw(900);     

     } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
     } catch (InsufficientBalanceException e) {
         System.out.println(e.getMessage());
     }
 }
}
