package com.company.platform.web.screens.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.platform.entity.Employee;

@UiController("platform_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {
}