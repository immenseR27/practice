package com.company.platform.service;

import com.company.platform.entity.Course;
import com.company.platform.entity.Employee;
import com.company.platform.entity.EmployeeCourse;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(CourseService.NAME)
public class CourseServiceBean implements CourseService {

    @Inject
    private DataManager dataManager;

    @Override
    public List<Course> getCourses(List<EmployeeCourse> employeeCourses) {
        return dataManager.load(Course.class)
                .query("select c from platform_EmployeeCourse ec join ec.course c " +
                        "where ec in :employeeCourses")
                .parameter("employeeCourses", employeeCourses)
                .list();
    }

    @Override
    public List<Course> getCourses() {
        return dataManager.load(Course.class)
                .query("select c from platform_Course c ")
//                       + "where q.chapter = :chapter")
//                .parameter("chapter", chapter)
                .list();

    }
}