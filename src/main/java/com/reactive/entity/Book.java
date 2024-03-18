package com.reactive.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_details")
public class Book {
    @Id
    @Column("book_id")
    private int bookId;
    private String name;
    private String author;
    @Column("book_desc")
    private String description;
    private String publisher;

    public Book() {
    }

    public Book(int bookId, String name, String author, String description, String publisher) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.description = description;
        this.publisher = publisher;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
