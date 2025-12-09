package com.legacy.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class InventoryManager {
    public List<String> p = new ArrayList<>(); // products
    public List<Double> pr = new ArrayList<>(); // prices
    public List<Integer> q = new ArrayList<>(); // quantities

    public void addForTests() {
        p.add("Widget"); pr.add(10.0); q.add(5);
        p.add("Gadget"); pr.add(20.0); q.add(3);
        p.add("Widget"); pr.add(10.0); q.add(2); // Duplicate
    }

    // Refactored: Optimized check using HashSet (O(n))
    public void processProducts() {
        System.out.println("Processing products...");
        Set<String> seenProducts = new HashSet<>();

        for (int i = 0; i < p.size(); i++) {
            String productName = p.get(i);
            Double price = pr.get(i);
            Integer quantity = q.get(i);
            
            if (seenProducts.contains(productName)) {
                System.out.println("Duplicate found: " + productName);
            }
            seenProducts.add(productName);
            
            JsonObject productJson = new JsonObject();
            productJson.addProperty("name", productName);
            productJson.addProperty("val", price * quantity);
            System.out.println(productJson);
        }
    }

    public double getTotalStockValue() {
        double total = 0.0;
        double tax = 0.05; // 5% tax or something

        for (int i = 0; i < p.size(); i++) {
            total += pr.get(i) * q.get(i);
        }

        // FIXED: Logic Error (was subtracting tax)
        return total + (total * tax); 
    }

    public String getInventoryJson() {
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < p.size(); i++) {
            JsonObject productJson = new JsonObject();
            productJson.addProperty("name", p.get(i));
            productJson.addProperty("price", pr.get(i));
            productJson.addProperty("quantity", q.get(i));
            jsonArray.add(productJson);
        }
        return jsonArray.toString();
    }
}
