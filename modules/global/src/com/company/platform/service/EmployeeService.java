package com.company.platform.service;

import com.company.platform.entity.Employee;

public interface EmployeeService {
    String NAME = "platform_EmployeeService";

    Employee loadEmployee(String login, String pass);
}