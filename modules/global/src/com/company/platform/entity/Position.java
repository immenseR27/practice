package com.company.platform.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.List;

@Table(name = "PLATFORM_POSITION")
@Entity(name = "platform_Position")
public class Position extends StandardEntity {
    private static final long serialVersionUID = -5649574933267801321L;

    @Column(name = "CODE")
    private Integer code;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    private List<Employee> employees;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}