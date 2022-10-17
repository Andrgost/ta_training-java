package com.epam.training.aleksandr_gostev.classes_main_task;

public class Book {

    private int id;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private double price;
    private String cover;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Book () {}

    public Book (String author, String publisher, int year) {
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

    public Book (int id, String title, String author, String publisher, int year, double price, String cover) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
        this.cover = cover;
    }

    @Override
    public String toString() {
        return  "id = " + id +
                ", title = " + title +
                ", author = " + author +
                ", publisher = " + publisher +
                ", year = " + year +
                ", price = " + price +
                ", cover = " + cover;
    }
}
