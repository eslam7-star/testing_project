package com.example.demo1;

class InventoryItem {
    private static int items_count = 0;

    private int Item_id;
    private String name;
    private int quantity;
    private double price;
    private String expiryDate;

    public InventoryItem(int itemId, String name, int quantity, double price, String expiryDate) {
        items_count++;
        Item_id = itemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public static int get_items_count() {
        return items_count;
    }

    public int getItem_id() {
        return Item_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
