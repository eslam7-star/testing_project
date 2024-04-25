package com.example.demo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventoryItem {

    public static List<InventoryItem> Items = new ArrayList<>();
    private static int items_count = 0;

    private int Item_id;
    private String name;
    private int quantity;
    private double price;
    private LocalDate expiryDate;

    public InventoryItem(String name, int quantity, double price, LocalDate expiryDate) {
        items_count++;
        Item_id = items_count;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
        Items.add(this);
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

    public int getQuantity() { return quantity;}

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

}
