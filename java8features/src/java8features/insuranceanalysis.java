package java8features;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class InsurancePolicy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getHolderName() { return holderName; }
    public double getPremiumAmount() { return premiumAmount; }

    @Override
    public String toString() {
        return String.format("Policy[%s, %s, $%.2f]", policyNumber, holderName, premiumAmount);
    }
}

public class insuranceanalysis {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("P101", "Alice Smith", 1500),
            new InsurancePolicy("P102", "Bob Johnson", 900),
            new InsurancePolicy("P103", "Charlie White", 2000),
            new InsurancePolicy("P104", "David Smith", 2500),
            new InsurancePolicy("P105", "Eve Jackson", 1300)
        );

        List<InsurancePolicy> filtered = policies.stream()
            .filter(p -> p.getPremiumAmount() > 1200)
            .collect(Collectors.toList());

        List<InsurancePolicy> sortedByName = policies.stream()
            .sorted(Comparator.comparing(InsurancePolicy::getHolderName))
            .collect(Collectors.toList());

        double totalPremium = policies.stream()
            .mapToDouble(InsurancePolicy::getPremiumAmount)
            .sum();

        policies.forEach(System.out::println);

        List<InsurancePolicy> rangeFiltered = policies.stream()
            .filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000)
            .collect(Collectors.toList());

        Optional<InsurancePolicy> highest = policies.stream()
            .max(Comparator.comparing(InsurancePolicy::getPremiumAmount));

        Map<Character, List<InsurancePolicy>> groupedByInitial = policies.stream()
            .collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));

        double avgPremium = policies.stream()
            .mapToDouble(InsurancePolicy::getPremiumAmount)
            .average().orElse(0.0);

        policies.stream()
            .sorted(Comparator.comparing(InsurancePolicy::getPremiumAmount))
            .forEach(System.out::println);

        boolean hasHighPremium = policies.stream()
            .anyMatch(p -> p.getPremiumAmount() > 2000);

        Map<String, Long> countByRange = policies.stream()
            .collect(Collectors.groupingBy(p -> {
                double premium = p.getPremiumAmount();
                if (premium <= 1000) return "$0–$1000";
                else if (premium <= 2000) return "$1001–$2000";
                else return ">$2000";
            }, Collectors.counting()));

        Set<String> uniqueNames = policies.stream()
            .map(InsurancePolicy::getHolderName)
            .collect(Collectors.toSet());

        List<InsurancePolicy> smithPolicies = policies.stream()
            .filter(p -> p.getHolderName().contains("Smith"))
            .collect(Collectors.toList());

        Map<String, Double> policyToPremium = policies.stream()
            .collect(Collectors.toMap(
                InsurancePolicy::getPolicyNumber,
                InsurancePolicy::getPremiumAmount
            ));

        String text = "Java is great. Java is powerful. Streams and Lambda expressions are powerful in Java.";
        Map<String, Long> wordFreq = Arrays.stream(text.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+"))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        wordFreq.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(3)
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        String input = "cat dog cat bird dog cat dog bird dog bird";
        Map<String, Long> freq = Arrays.stream(input.split("\\s+"))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Map.Entry<String, Long>> sorted = freq.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .collect(Collectors.toList());
        if (sorted.size() >= 2) {
            Map.Entry<String, Long> second = sorted.get(1);
            System.out.println("Second Most Frequent: " + second.getKey() + " -> " + second.getValue());
        }
    }
}
