package com.xx.domain;

public class Book {
    private Long bookId;
    private String name;
    private String introd;
    private int number;

    public Book() {
    }

    public Book(Long bookId, String name, String introd, int number) {
        this.bookId = bookId;
        this.name = name;
        this.introd = introd;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", introd='" + introd + '\'' +
                ", number=" + number +
                '}';
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntrod() {
        return introd;
    }

    public void setIntrod(String introd) {
        this.introd = introd;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
