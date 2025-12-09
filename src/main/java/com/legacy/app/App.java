package com.legacy.app;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting Legacy Warehouse App...");
        
        DatabaseConnection db = new DatabaseConnection();
        db.connect();

        InventoryManager im = new InventoryManager();
        im.addForTests();
        im.processProducts();
        
        // COMPILATION ERROR: Missing semicolon
        System.out.println("Total Stock Value: " + im.getTotalStockValue()); 
    }
}
