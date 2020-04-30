package com.example.madminiproject;

public class Cart {
    private String pcode,pname,price,qty;

        public Cart() {
        }

    public Cart(String pcode, String pname, String price, String qty) {
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
        this.qty = qty;

    }


    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
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


}
