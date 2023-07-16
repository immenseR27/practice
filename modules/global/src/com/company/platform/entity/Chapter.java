package com.company.platform.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.List;

@Table(name = "PLATFORM_CHAPTER")
@Entity(name = "platform_Chapter")
@NamePattern("%s. %s|number,name")
public class Chapter extends StandardEntity {
    private static final long serialVersionUID = 7450342442393762622L;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chapter")
    private List<Question> questions;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chapter")
//    private List<EmployeeChapter> chapterEmployees;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}