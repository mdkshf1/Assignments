package com.mappinginjpa.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
public class Author {
    @Id
    private int authorid;
    private String authorname;
    @Embedded
    private Address address;
    @OneToOne
    @JoinColumn(name ="book_id")
    private Book book;

    private ArrayList<Subject> subjectList;

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(ArrayList<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}

/*@Data
@Entity
public class Author {
    @Id
    private int authorid;
    private String authorname;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "author",cascade = cascade.PERSIST)
    private List<Book> book;
}*/


/*
@Data
@Entity
public class Author {
    @Id
    private int authorid;
    private String authorname;
    @Embedded
    private Address address;
    @ManyToMany
    private List<Book> book;
}
*/


