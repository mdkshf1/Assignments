package com.employee.employeeassignment.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="record_type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value = "person_type")

/*@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)*/

/*@Inheritance(strategy=InheritanceType.JOINED)*/


public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name",length=100)
    private String name;

    @Column(name="gender",length=10)
    private String gender;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}
