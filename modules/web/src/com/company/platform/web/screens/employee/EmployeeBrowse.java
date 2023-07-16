package com.company.platform.web.screens.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.platform.entity.Employee;

@UiController("platform_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeBrowse extends StandardLookup<Employee> {
}