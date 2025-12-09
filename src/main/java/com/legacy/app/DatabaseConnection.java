package com.legacy.app;

public class DatabaseConnection {
    private String dbUrl = "jdbc:mysql://localhost:3306/warehouse";
    private String dbUser = "admin";
    
    // SECURITY VULNERABILITY: Hardcoded password
    // FIXED: Load password from environment variable
    private String dbPassword = System.getenv("DB_PASSWORD"); 

    public void connect() {
        if (dbPassword == null) {
            System.err.println("Error: DB_PASSWORD environment variable not set.");
            return;
        }

        System.out.println("Connecting to database...");
        System.out.println("Using user: " + dbUser);
        // FIXED: Do NOT print password to console
        System.out.println("Connected successfully (Mock)!");
    }
}
