package com.epam.training.aleksandr_gostev.classes_main_task;

public class BookSearch {
    public static void main(String[] args) {
        Book book1 = new Book("Author1", "Publisher1", 1111);
        Book book2 = new Book("Author2", "Publisher2", 1111);
        Book book3 = new Book("Author3", "Publisher3", 3333);
        Book book4 = new Book("Author2", "Publisher3", 3333);
        Book book5 = new Book("Author3", "Publisher3", 5555);

        BookManager bookManager = new BookManager();
        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);
        bookManager.addBook(book4);
        bookManager.addBook(book5);

        bookManager.searchBookByAuthor("Author2");
        bookManager.searchBookByPublisher("Publisher3");
        bookManager.searchBookByYear(1111);
    }
}
