package com.company.platform.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "PLATFORM_EMPLOYEE_CHAPTER", uniqueConstraints={
        @UniqueConstraint(columnNames={"EMPLOYEE_ID", "CHAPTER_ID"})})
@Entity(name = "platform_EmployeeChapter")
public class EmployeeChapter extends StandardEntity {
    private static final long serialVersionUID = 9107959884126164421L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHAPTER_ID")
    private Chapter chapter;

    @Column(name = "SCORE")
    private Double score;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}