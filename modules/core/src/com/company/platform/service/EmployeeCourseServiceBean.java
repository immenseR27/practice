package com.company.platform.service;

import com.company.platform.entity.Course;
import com.company.platform.entity.Employee;
import com.company.platform.entity.EmployeeCourse;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(EmployeeCourseService.NAME)
public class EmployeeCourseServiceBean implements EmployeeCourseService {

    @Inject
    private DataManager dataManager;

    @Override
    public List<EmployeeCourse> getEmployeeCourses(Employee employee) {
        return dataManager.load(EmployeeCourse.class)
                .query("select ec from platform_EmployeeCourse ec where ec.employee = :employee")
                .parameter("employee", employee)
                .list();

    }
}