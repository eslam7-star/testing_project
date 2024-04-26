package hospital_junit_project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
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
    void testSetNegativeQuantity() {
        inventoryItem.setQuantity(-25);
        assertEquals(10, inventoryItem.getQuantity());
        assertNotEquals(-25,inventoryItem.getQuantity());
    }
	@Test
	void testsetzertoQuantity() {
		 inventoryItem.setQuantity(0);
	     assertEquals(0, inventoryItem.getQuantity());
	}
    @Test
    void testGetPrice() {
        assertEquals(100.0, inventoryItem.getPrice());
    }

  

    
    @AfterEach
    void tearDown() {
        inventoryItem = null;
    }
    @Test
    void testSetNegativePrice() {
        inventoryItem.setPrice(-200.0);
        assertEquals(100.0, inventoryItem.getPrice());
        assertNotEquals(-200.0, inventoryItem.getPrice());

    }  
    @Test
    void tessetnormalPrice() {
    	  inventoryItem.setPrice(5000);
          assertEquals(5000, inventoryItem.getPrice());
    }
    @Test
    void tessethighPrice() {
    	  inventoryItem.setPrice(50000);
          assertNotEquals(50000, inventoryItem.getPrice());
          assertEquals(100.0, inventoryItem.getPrice());

    }
    @Test
    void tessetlowPrice() {
    	  inventoryItem.setPrice(1);
          assertNotEquals(1, inventoryItem.getPrice());
          assertEquals(100.0, inventoryItem.getPrice());

    }
    
    @Test
    void testSetlowerboundryPrice() {
        inventoryItem.setPrice(4.9999);
        assertNotEquals(4.9999, inventoryItem.getPrice());
        assertEquals(100.0, inventoryItem.getPrice());

    }
    @Test
    void testSethigherboundryPrice() {
        inventoryItem.setPrice(10000.0001);
        assertNotEquals(10000.0001, inventoryItem.getPrice());
        assertEquals(100.0, inventoryItem.getPrice());

    }
    @Test
    void testSetboundryPrice() {
        inventoryItem.setPrice(10000);
        assertEquals(10000.0, inventoryItem.getPrice());

    }
    @Test
    void testSetsecondboundryPrice() {
        inventoryItem.setPrice(5);
        assertEquals(5.0, inventoryItem.getPrice());

    }

    @Test
    void testSetExpiryDate() {
        inventoryItem.setExpiryDate("2025-12-31");
        assertEquals("2025-12-31", inventoryItem.getExpiryDate());
    }

    @Test
    void testSetoldExpiryDate() {
        inventoryItem.setExpiryDate("2024-04-25");
        assertNotEquals("2024-04-25", inventoryItem.getExpiryDate());
        assertEquals("2024-12-31", inventoryItem.getExpiryDate());

    }
    
    @Test 
    void testsetveryolddate() {
    	inventoryItem.setExpiryDate("2003-05-20");
        assertNotEquals("2003-05-20", inventoryItem.getExpiryDate());
        assertEquals("2024-12-31", inventoryItem.getExpiryDate());
    }
    @Test 
    void testsetfuturedate() {
    	inventoryItem.setExpiryDate("2027-12-30");
        assertEquals("2027-12-30", inventoryItem.getExpiryDate());

    }
}

