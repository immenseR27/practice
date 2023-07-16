package com.company.platform.service;

import com.company.platform.entity.Course;
import com.company.platform.entity.Employee;
import com.company.platform.entity.EmployeeCourse;
import com.haulmont.cuba.core.global.DataManager;

import javax.inject.Inject;
import java.util.List;

public interface EmployeeCourseService {
    String NAME = "platform_EmployeeCourseService";

    public List<EmployeeCourse> getEmployeeCourses(Employee employee);

}