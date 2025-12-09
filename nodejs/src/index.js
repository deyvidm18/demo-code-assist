const DatabaseConnection = require('./databaseConnection');
const InventoryManager = require('./inventoryManager');

console.log("Starting Legacy Warehouse App...");

const db = new DatabaseConnection();
db.connect();

const im = new InventoryManager();
im.addForTests();
im.processProducts();

// SYNTAX ERROR: Missing closing parenthesis (mimicking Java's missing semicolon which stops compilation)
console.log("Total Stock Value: " + im.getTotalStockValue()
