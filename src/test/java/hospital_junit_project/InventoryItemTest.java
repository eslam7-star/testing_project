package hospital_junit_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;

class InventoryItemTest {
    private InventoryItem inventoryItem;

    @BeforeEach
    void setUp() {
        inventoryItem = new InventoryItem(1, "Test Item", 10, 100.0, "2024-12-31");
    }

    @Test
    void testGetItemId() {
        assertEquals(1, inventoryItem.getItem_id());
    }

    @Test
    void testGetName() {
        assertEquals("Test Item", inventoryItem.getName());
    }

    @Test
    void testSetName() {
        inventoryItem.setName("New Test Item");
        assertEquals("New Test Item", inventoryItem.getName());
    }

    @Test
    void testGetQuantity() {
        assertEquals(10, inventoryItem.getQuantity());
    }

    @Test
    void testSetQuantity() {
        inventoryItem.setQuantity(20);
        assertEquals(20, inventoryItem.getQuantity());
    }

    @Test
    void testGetPrice() {
        assertEquals(100.0, inventoryItem.getPrice());
    }

    @Test
    void testSetPrice() {
        inventoryItem.setPrice(200.0);
        assertEquals(200.0, inventoryItem.getPrice());
    }

    @Test
    void testGetExpiryDate() {
        assertEquals("2024-12-31", inventoryItem.getExpiryDate());
    }

    @Test
    void testSetExpiryDate() {
        inventoryItem.setExpiryDate("2025-12-31");
        assertEquals("2025-12-31", inventoryItem.getExpiryDate());
    }
    
    @AfterEach
    void tearDown() {
        inventoryItem = null;
    }
    
}

