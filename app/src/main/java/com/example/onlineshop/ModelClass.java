package com.example.onlineshop;

public class ModelClass {
    private int image;
    private String product;
    private String amount;
    private  String description;

    ModelClass(int image,String product,String amount,String description){
        this.image=image;
        this.product=product;
        this.amount=amount;
        this.description=description;
    }

    public int getImage() {
        return image;
    }

    public String getProduct() {
        return product;
    }

    public String getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
