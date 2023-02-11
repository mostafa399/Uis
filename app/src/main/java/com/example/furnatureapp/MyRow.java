package com.example.furnatureapp;

public class MyRow {
    private int image;
    private String title,desc;

    public MyRow(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public MyRow() {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
