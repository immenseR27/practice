package com.company.platform.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.List;

@Table(name = "PLATFORM_COURSE")
@Entity(name = "platform_Course")
@NamePattern("%s|name")
public class Course extends StandardEntity {
    private static final long serialVersionUID = 724913713094114309L;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee author;

    @Column(name="SOURCE")
    private String source;

    @Column(name = "SIZE")
    private Integer size;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<EmployeeCourse> courseEmployees;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHAPTER_ID")
    private List<Chapter> chapters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getAuthor() {
        return author;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public List<EmployeeCourse> getCourseEmployees() {
        return courseEmployees;
    }

    public void setCourseEmployees(List<EmployeeCourse> courseEmployees) {
        this.courseEmployees = courseEmployees;
    }
}