package com.company.platform.service;

import com.company.platform.entity.Course;
import com.company.platform.entity.Employee;
import com.company.platform.entity.EmployeeCourse;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.core.global.ViewBuilder;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(EmployeeService.NAME)
public class EmployeeServiceBean implements EmployeeService {

    @Inject
    private DataManager dataManager;
    @Inject
    private Logger log;

    @Override
    public Employee loadEmployee(String login, String pass) {
        return dataManager.loadValue("select e from platform_Employee e where " +
                "e.login = :login and e.pass = :pass", Employee.class)
                .parameter("login", login)
                .parameter("pass", pass)
                .one();
    }
}