package collections;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Policy {
    String policyNumber;
    String policyHolderName;
    LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return policyNumber + " - " + policyHolderName + " - Expires: " + expiryDate;
    }
}

class PolicyManager {
    Map<String, Policy> hashMap = new HashMap<>();
    Map<String, Policy> linkedMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> treeMapByExpiry = new TreeMap<>();

    public void addPolicy(Policy policy) {
        hashMap.put(policy.policyNumber, policy);
        linkedMap.put(policy.policyNumber, policy);
        treeMapByExpiry
            .computeIfAbsent(policy.expiryDate, k -> new ArrayList<>())
            .add(policy);
    }

    public Policy getPolicyByNumber(String number) {
        return hashMap.get(number);
    }

    public List<Policy> getPoliciesExpiringInNext30Days() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        return treeMapByExpiry.subMap(today, true, limit, true)
                .values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Policy> getPoliciesByHolder(String holderName) {
        return hashMap.values()
                .stream()
                .filter(p -> p.policyHolderName.equalsIgnoreCase(holderName))
                .collect(Collectors.toList());
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        List<String> toRemove = new ArrayList<>();

        for (Policy p : hashMap.values()) {
            if (p.expiryDate.isBefore(today)) {
                toRemove.add(p.policyNumber);
            }
        }

        for (String key : toRemove) {
            Policy removed = hashMap.remove(key);
            linkedMap.remove(key);
            if (removed != null) {
                List<Policy> list = treeMapByExpiry.get(removed.expiryDate);
                if (list != null) {
                    list.remove(removed);
                    if (list.isEmpty()) {
                        treeMapByExpiry.remove(removed.expiryDate);
                    }
                }
            }
        }
    }

    public void displayAllPolicies() {
        System.out.println("All Policies (Insertion Order):");
        linkedMap.values().forEach(System.out::println);
    }
}

public class insurancesystem {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10)));
        manager.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40)));
        manager.addPolicy(new Policy("P003", "Alice", LocalDate.now().minusDays(5)));
        manager.addPolicy(new Policy("P004", "Charlie", LocalDate.now().plusDays(20)));

        System.out.println("\nPolicies expiring in next 30 days:");
        manager.getPoliciesExpiringInNext30Days().forEach(System.out::println);

        System.out.println("\nPolicies for 'Alice':");
        manager.getPoliciesByHolder("Alice").forEach(System.out::println);

        System.out.println("\nRemoving expired policies...");
        manager.removeExpiredPolicies();

        System.out.println("\nCurrent active policies:");
        manager.displayAllPolicies();
    }
}
