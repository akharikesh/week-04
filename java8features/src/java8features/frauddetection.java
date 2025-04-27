package java8features;

import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    private String transactionId;
    private String policyNumber;
    private double amount;
    private Date transactionDate;
    private boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, Date transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public String getTransactionId() { return transactionId; }
    public String getPolicyNumber() { return policyNumber; }
    public double getAmount() { return amount; }
    public Date getTransactionDate() { return transactionDate; }
    public boolean isFraudulent() { return isFraudulent; }
}

class FraudStats {
    private long transactionCount;
    private double totalAmount;

    public FraudStats(long transactionCount, double totalAmount) {
        this.transactionCount = transactionCount;
        this.totalAmount = totalAmount;
    }

    public long getTransactionCount() { return transactionCount; }
    public double getTotalAmount() { return totalAmount; }

    @Override
    public String toString() {
        return "Fraud Count: " + transactionCount + ", Total Amount: $" + totalAmount;
    }
}

public class frauddetection {

    public static void detectFraud(List<Transaction> transactions) {
        List<Transaction> filtered = transactions.stream()
            .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
            .collect(Collectors.toList());

        Map<String, FraudStats> fraudStatsByPolicy = filtered.stream()
            .collect(Collectors.groupingBy(
                Transaction::getPolicyNumber,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    txList -> {
                        long count = txList.size();
                        double total = txList.stream().mapToDouble(Transaction::getAmount).sum();
                        return new FraudStats(count, total);
                    }
                )
            ));

        System.out.println("=== Fraud Alerts ===");
        fraudStatsByPolicy.entrySet().stream()
            .filter(entry -> entry.getValue().getTransactionCount() > 5 || entry.getValue().getTotalAmount() > 50000)
            .forEach(entry -> {
                System.out.println("Policy: " + entry.getKey() + " | " + entry.getValue());
            });
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T001", "P1001", 12000, new Date(), true),
            new Transaction("T002", "P1001", 15000, new Date(), true),
            new Transaction("T003", "P1001", 17000, new Date(), true),
            new Transaction("T004", "P1001", 14000, new Date(), true),
            new Transaction("T005", "P1001", 16000, new Date(), true),
            new Transaction("T006", "P1001", 18000, new Date(), true),
            new Transaction("T007", "P2002", 30000, new Date(), true),
            new Transaction("T008", "P3003", 5000, new Date(), true),
            new Transaction("T009", "P3003", 25000, new Date(), false)
        );

        detectFraud(transactions);
    }
}
