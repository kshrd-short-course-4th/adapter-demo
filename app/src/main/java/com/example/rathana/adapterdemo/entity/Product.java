package com.example.rathana.adapterdemo.entity;

/**
 * Created by RATHANA on 1/13/2018.
 */

public class Product {
    private int image;
    private String title;

    public Product(int image, String title) {
        this.image = image;
        this.title = title;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
