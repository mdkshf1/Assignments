package com.mappinginjpa.entities;

import javax.persistence.*;
import java.util.List;


@Entity
public class Book {
    @Id
    private int bookid;
    private String bookname;
    @OneToOne(mappedBy = "book")
    private Author author;

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book(int bookid, String bookname, Author author) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
    }

    public Book() {
    }
}

/*
@Entity
public class Book {
    @Id
    private int bookid;
    private String bookname;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}*/

/*@Entity
public class Book {
    @Id
    private int bookid;
    private String bookname;
    @ManyToMany(mappedBy = "book")
    private List<Author> author;
}*/
