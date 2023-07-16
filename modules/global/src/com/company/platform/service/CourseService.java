package com.company.platform.service;

import com.company.platform.entity.Course;
import com.company.platform.entity.Employee;
import com.company.platform.entity.EmployeeCourse;

import java.util.List;

public interface CourseService {
    String NAME = "platform_CourseService";

    public List<Course> getCourses();

    public List<Course> getCourses(List<EmployeeCourse> employeeCourses);
}