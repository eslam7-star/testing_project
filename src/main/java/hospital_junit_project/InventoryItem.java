package hospital_junit_project;

class InventoryItem {
    private int itemId;
    private String name;
    private int quantity;
    private double price;
    private String expiryDate;

    public InventoryItem(int itemId, String name, int quantity, double price, String expiryDate) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }
    
}
