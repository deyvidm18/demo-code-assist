package com.legacy.app;

public class DatabaseConnection {
    private String dbUrl = "jdbc:mysql://localhost:3306/warehouse";
    private String dbUser = "admin";
    
    // SECURITY VULNERABILITY: Hardcoded password
    private String dbPassword = "admin123"; 

    public void connect() {
        System.out.println("Connecting to database...");
        System.out.println("Using user: " + dbUser);
        // SECURITY VULNERABILITY: Printing password to console
        System.out.println("Using password: " + dbPassword); 
        System.out.println("Connected successfully (Mock)!");
    }
}
