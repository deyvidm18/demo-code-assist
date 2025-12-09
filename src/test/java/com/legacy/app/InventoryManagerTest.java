package com.legacy.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class InventoryManagerTest {

    private InventoryManager inventoryManager;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        inventoryManager = new InventoryManager();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testGetTotalStockValue() {
        // Setup output
        inventoryManager.p.add("TestItem");
        inventoryManager.pr.add(100.0);
        inventoryManager.q.add(2); // Value = 200

        // Expected: 200 + 5% tax = 210.0
        double expected = 210.0;
        double delta = 0.001;

        assertEquals(expected, inventoryManager.getTotalStockValue(), delta);
    }

    @Test
    public void testProcessProductsOutput() {
        inventoryManager.p.add("ItemA");
        inventoryManager.pr.add(10.0);
        inventoryManager.q.add(5);

        inventoryManager.processProducts();
        
        String output = outContent.toString();
        // Check if output contains expected JSON part
        assertTrue(output.contains("\"name\":\"ItemA\""));
        assertTrue(output.contains("\"val\":50.0"));
    }

    @Test
    public void testProcessProductsDuplicateDetection() {
        inventoryManager.p.add("ItemA");
        inventoryManager.pr.add(10.0);
        inventoryManager.q.add(5);
        
        inventoryManager.p.add("ItemA"); // Duplicate
        inventoryManager.pr.add(12.0);
        inventoryManager.q.add(1);

        inventoryManager.processProducts();

        String output = outContent.toString();
        // Should detect duplicate
        assertTrue(output.contains("Duplicate found: ItemA"));
    }

    @Test
    public void testGetInventoryJson() {
        inventoryManager.p.add("ExportItem");
        inventoryManager.pr.add(15.0);
        inventoryManager.q.add(10);
        
        String json = inventoryManager.getInventoryJson();
        assertTrue(json.contains("\"name\":\"ExportItem\""));
        assertTrue(json.contains("\"price\":15.0"));
        assertTrue(json.contains("\"quantity\":10"));
    }
}
