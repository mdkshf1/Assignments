package com.mappinginjpa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
    @Id
    private String subjectname;

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public Subject() {
        this.subjectname = subjectname;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectname='" + subjectname + '\'' +
                '}';
    }
}
