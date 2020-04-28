package com.example.madminiproject;


public final class ItemModel {

    private String code;
    private String date;
    private String name;
    private String price;
    private String description;
    private String size;
    private Integer qty;
    private String img;
    private String key;

    public ItemModel(String code, String date, String name, String price, String description, String size, Integer qty, String img) {

        this.code = code;
        this.date = date;
        this.name = name;
        this.price = price;
        this.description = description;
        this.size = size;
        this.qty = qty;
        this.img = img;
    }

    public ItemModel() {
    }


    public String getKey() { return key; }

    public void setKey(String key){ this.key = key; }

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
