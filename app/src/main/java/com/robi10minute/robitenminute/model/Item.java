package com.robi10minute.robitenminute.model;

public class Item {
    private int img;
    private String title, author;
    private boolean isExpandable;

    public Item() {
    }

    public Item(String title) {
        this.title = title;
        this.isExpandable = false;
    }

    public Item(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public Item(int img, String title, String author) {
        this.img = img;
        this.title = title;
        this.author = author;
    }

    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }

    @Override
    public String toString() {
        return "Item{" +
                "img=" + img +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isExpandable=" + isExpandable +
                '}';
    }
}
