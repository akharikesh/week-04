package java8features;

import java.util.*;
import java.util.stream.Collectors;

class Claim {
    private String claimId;
    private String policyNumber;
    private double claimAmount;
    private Date claimDate;
    private String status;

    public Claim(String claimId, String policyNumber, double claimAmount, Date claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public String getClaimId() { return claimId; }
    public String getPolicyNumber() { return policyNumber; }
    public double getClaimAmount() { return claimAmount; }
    public Date getClaimDate() { return claimDate; }
    public String getStatus() { return status; }
}

class ClaimStats {
    private String policyNumber;
    private double totalAmount;
    private double averageAmount;

    public ClaimStats(String policyNumber, double totalAmount, double averageAmount) {
        this.policyNumber = policyNumber;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public double getTotalAmount() { return totalAmount; }
    public double getAverageAmount() { return averageAmount; }

    @Override
    public String toString() {
        return "Policy: " + policyNumber +
               ", Total Claimed: $" + totalAmount +
               ", Average Claimed: $" + String.format("%.2f", averageAmount);
    }
}

public class claimsanalysis {

    public static void analyzeClaims(List<Claim> claims) {
        List<Claim> filtered = claims.stream()
            .filter(c -> "Approved".equalsIgnoreCase(c.getStatus()) && c.getClaimAmount() > 5000)
            .collect(Collectors.toList());

        Map<String, List<Claim>> groupedByPolicy = filtered.stream()
            .collect(Collectors.groupingBy(Claim::getPolicyNumber));

        List<ClaimStats> statsList = groupedByPolicy.entrySet().stream()
            .map(entry -> {
                String policy = entry.getKey();
                List<Claim> policyClaims = entry.getValue();
                double total = policyClaims.stream().mapToDouble(Claim::getClaimAmount).sum();
                double avg = total / policyClaims.size();
                return new ClaimStats(policy, total, avg);
            })
            .collect(Collectors.toList());

        List<ClaimStats> topPolicies = statsList.stream()
            .sorted((a, b) -> Double.compare(b.getTotalAmount(), a.getTotalAmount()))
            .limit(3)
            .collect(Collectors.toList());

        System.out.println("Top 3 Policies by Total Claim Amount:");
        topPolicies.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("C001", "P1001", 8000, new Date(), "Approved"),
            new Claim("C002", "P1002", 12000, new Date(), "Approved"),
            new Claim("C003", "P1001", 6000, new Date(), "Approved"),
            new Claim("C004", "P1003", 4000, new Date(), "Approved"),
            new Claim("C005", "P1002", 15000, new Date(), "Approved"),
            new Claim("C006", "P1004", 7000, new Date(), "Pending"),
            new Claim("C007", "P1003", 9000, new Date(), "Approved"),
            new Claim("C008", "P1001", 3000, new Date(), "Rejected")
        );

        analyzeClaims(claims);
    }
}

