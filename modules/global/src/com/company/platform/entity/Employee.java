package com.company.platform.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.datatypes.Datatype;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static org.codehaus.groovy.tools.shell.util.Logger.io;

@Table(name = "PLATFORM_EMPLOYEE")
@Entity(name = "platform_Employee")
@NamePattern(("%s %s %s|lastName,firstName,fatherName"))
public class Employee extends StandardEntity {
    private static final long serialVersionUID = -284948196541064737L;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "FATHER_NAME")
    private String fatherName;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSITION_ID")
    private Position position;

    @Column(name = "EMPLOYMENT_DATE")
    private LocalDate employmentDate;

    @Column(name = "DISMISSAL_DATE")
    private LocalDate dismissalDate;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASS")
    private String pass;

    @Column(name = "ROLE")
    private String role;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Course> createdCourses;
    //
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeCourse> employeeCourses;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeChapter> employeeChapters;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public LocalDate getDismissalDate() {
        return dismissalDate;
    }

    public void setDismissalDate(LocalDate dismissalDate) {
        this.dismissalDate = dismissalDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Course> getCreatedCourses() {
        return createdCourses;
    }

    public void setCreatedCourses(List<Course> createdCourses) {
        this.createdCourses = createdCourses;
    }

    public List<EmployeeCourse> getEmployeeCourses() {
        return employeeCourses;
    }

    public void setEmployeeCourses(List<EmployeeCourse> employeeCourses) {
        this.employeeCourses = employeeCourses;
    }

    public List<EmployeeChapter> getEmployeeChapters() {
        return employeeChapters;
    }

    public void setEmployeeChapters(List<EmployeeChapter> employeeChapters) {
        this.employeeChapters = employeeChapters;
    }
}