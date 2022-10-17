package com.epam.training.aleksandr_gostev.classes_main_task;

import java.util.Arrays;

public class BookManager {

    private Book[] booksList = new Book[5];

    public Book[] getBooksList() {
        return booksList;
    }

    public void setBooksList(Book[] booksList) {
        this.booksList = booksList;
    }

    public void addBook (Book book) {
        if (booksList[booksList.length - 1] != null) {
            System.out.println("Book list is full");
        }

        for (int i = 0; i < booksList.length; i++) {
            if (booksList[i] == null) {
                booksList[i] = book;
                break;
            }
        }
    }

    public void searchBookByAuthor(String author) {
        System.out.println(author + " list of books:");
        Arrays.stream(booksList).filter(book -> book.getAuthor().equals(author)).forEach(System.out::println);
    }

    public void searchBookByPublisher(String publisher) {
        System.out.println(publisher + " list of books:");
        Arrays.stream(booksList).filter(book -> book.getPublisher().equals(publisher)).forEach(System.out::println);
    }

    public void searchBookByYear(int year) {
        System.out.println(year + " list of books:");
        Arrays.stream(booksList).filter(book -> book.getYear() > year).forEach(System.out::println);
    }

    public void printBooks() {
        Arrays.stream(booksList).map(Book::toString).forEach(System.out::println);
    }
}
