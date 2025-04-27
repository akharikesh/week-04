package java8features;

import java.util.*;
import java.util.stream.Collectors;

class Sale {
    private String productId;
    private int quantity;
    private double price;

    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}

class ProductSales {
    private String productId;
    private double totalRevenue;

    public ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public String getProductId() { return productId; }
    public double getTotalRevenue() { return totalRevenue; }

    @Override
    public String toString() {
        return productId + " - Revenue: $" + totalRevenue;
    }
}

public class productsalesanalysis {

    public static void analyzeSales(List<Sale> sales) {
        List<Sale> filteredSales = sales.stream()
            .filter(s -> s.getQuantity() > 10)
            .collect(Collectors.toList());

        Map<String, Double> revenueMap = filteredSales.stream()
            .collect(Collectors.groupingBy(
                Sale::getProductId,
                Collectors.summingDouble(s -> s.getQuantity() * s.getPrice())
            ));

        List<ProductSales> sortedSales = revenueMap.entrySet().stream()
            .map(entry -> new ProductSales(entry.getKey(), entry.getValue()))
            .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed())
            .collect(Collectors.toList());

        List<ProductSales> top5 = sortedSales.stream()
            .limit(5)
            .collect(Collectors.toList());

        System.out.println("Top 5 Products by Revenue:");
        top5.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale("P1", 5, 20.0),
            new Sale("P2", 15, 30.0),
            new Sale("P3", 8, 50.0),
            new Sale("P2", 7, 30.0),
            new Sale("P4", 12, 10.0),
            new Sale("P5", 20, 5.0),
            new Sale("P6", 25, 12.0),
            new Sale("P7", 11, 60.0)
        );

        analyzeSales(sales);
    }
}
