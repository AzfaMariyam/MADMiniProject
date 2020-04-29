package com.example.madminiproject;

public class Cart {
    private String code,pname,price,qty,size,color;

        public Cart() {
        }

    public Cart(String pid, String pname, String price, String qty, String size, String color) {
        this.code = code;
        this.pname = pname;
        this.price = price;
        this.qty = qty;
        this.size = size;
        this.color = color;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
