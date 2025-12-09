class DatabaseConnection {
    constructor() {
        this.dbUrl = "jdbc:mysql://localhost:3306/warehouse";
        this.dbUser = "admin";

        // SECURITY VULNERABILITY: Hardcoded password
        this.dbPassword = "admin123";
    }

    connect() {
        console.log("Connecting to database...");
        console.log("Using user: " + this.dbUser);
        // SECURITY VULNERABILITY: Printing password to console
        console.log("Using password: " + this.dbPassword);
        console.log("Connected successfully (Mock)!");
    }
}

module.exports = DatabaseConnection;
