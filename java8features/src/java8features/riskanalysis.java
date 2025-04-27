package java8features;

import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    private String holderId;
    private String name;
    private int age;
    private String policyType;
    private double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderId() { return holderId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPolicyType() { return policyType; }
    public double getPremiumAmount() { return premiumAmount; }
}

class RiskAssessment {
    private String holderId;
    private String name;
    private double riskScore;

    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public String getHolderId() { return holderId; }
    public String getName() { return name; }
    public double getRiskScore() { return riskScore; }

    @Override
    public String toString() {
        return holderId + " - " + name + " | Risk Score: " + String.format("%.3f", riskScore);
    }
}

public class riskanalysis {

    public static void assessRisk(List<PolicyHolder> holders) {
  
        List<PolicyHolder> filtered = holders.stream()
            .filter(h -> "Life".equalsIgnoreCase(h.getPolicyType()) && h.getAge() > 60)
            .collect(Collectors.toList());

        List<RiskAssessment> riskAssessments = filtered.stream()
            .map(h -> new RiskAssessment(
                h.getHolderId(),
                h.getName(),
                h.getPremiumAmount() / h.getAge()))
            .collect(Collectors.toList());

        riskAssessments.sort((a, b) -> Double.compare(b.getRiskScore(), a.getRiskScore()));

        Map<String, List<RiskAssessment>> categorized = riskAssessments.stream()
            .collect(Collectors.groupingBy(
                ra -> ra.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"
            ));

        System.out.println("=== High Risk Policyholders ===");
        categorized.getOrDefault("High Risk", Collections.emptyList())
                   .forEach(System.out::println);

        System.out.println("\n=== Low Risk Policyholders ===");
        categorized.getOrDefault("Low Risk", Collections.emptyList())
                   .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
            new PolicyHolder("PH001", "Alice", 65, "Life", 40000),
            new PolicyHolder("PH002", "Bob", 70, "Life", 20000),
            new PolicyHolder("PH003", "Charlie", 58, "Life", 18000),
            new PolicyHolder("PH004", "David", 75, "Health", 30000),
            new PolicyHolder("PH005", "Eve", 68, "Life", 45000),
            new PolicyHolder("PH006", "Frank", 62, "Life", 20000)
        );

        assessRisk(holders);
    }
}

