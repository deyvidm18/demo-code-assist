package com.legacy.app;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

public class InventoryManager {
    public List<String> p = new ArrayList<>(); // products
    public List<Double> pr = new ArrayList<>(); // prices
    public List<Integer> q = new ArrayList<>(); // quantities

    public void addForTests() {
        p.add("Widget"); pr.add(10.0); q.add(5);
        p.add("Gadget"); pr.add(20.0); q.add(3);
        p.add("Widget"); pr.add(10.0); q.add(2); // Duplicate
    }

    // Spaghetti code: confusing variable names, nested loops
    public void processProducts() {
        System.out.println("Processing products...");
        
        for (int i = 0; i < p.size(); i++) {
            String a = p.get(i);
            Double b = pr.get(i);
            Integer c = q.get(i);
            
            boolean d = false;
            // Inefficient O(n^2) check
            for (int k = 0; k < p.size(); k++) {
                if (i != k && p.get(k).equals(a)) {
                     d = true;
                }
            }

            if (d) {
                System.out.println("Duplicate found: " + a);
            }
            
            JSONObject obj = new JSONObject();
            obj.put("name", a);
            obj.put("val", b * c);
            System.out.println(obj);
        }
    }

    public double getTotalStockValue() {
        double total = 0.0;
        double tax = 0.05; // 5% tax or something

        for (int i = 0; i < p.size(); i++) {
            total += pr.get(i) * q.get(i);
        }

        // Logic Error: Subtracting tax instead of adding it (or just calculating total + tax)
        // Assuming we wanted Total + Tax
        return total - (total * tax); 
    }
}
