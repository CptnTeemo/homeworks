package ru.skillbox;

public class Book {

    private final String bookName;
    private final String bookAuthor;
    private final int amountPages;
    private final int id; // номер ISBN

    public Book(String bookName, String bookAuthor, int amountPages, int id) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.amountPages = amountPages;
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getAmountPages() {
        return amountPages;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return "Автор книги: " + bookAuthor + "\n" +
                "Название: " + bookName + "\n" +
                "Количество страниц: " + amountPages + "\n" +
                "Номер ISBN: " + id;
    }
}
