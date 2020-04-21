package com.example.madminiproject;


public final class ItemModel {

    private String code;
    private String date;
    private String name;
    private String price;
    private String description;
    private String color;
    private String size;
    private Integer qty;

    public ItemModel(String code, String date, String name, String price, String description, String color, String size, Integer qty) {

        this.code = code;
        this.date = date;
        this.name = name;
        this.price = price;
        this.description = description;
        this.color = color;
        this.size = size;
        this.qty = qty;
    }

    public ItemModel() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
