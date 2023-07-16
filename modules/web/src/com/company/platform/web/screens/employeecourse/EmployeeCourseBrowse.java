package com.company.platform.web.screens.employeecourse;

import com.haulmont.cuba.gui.screen.*;
import com.company.platform.entity.EmployeeCourse;

@UiController("platform_EmployeeCourse.browse")
@UiDescriptor("employee-course-browse.xml")
@LookupComponent("employeeCoursesTable")
@LoadDataBeforeShow
public class EmployeeCourseBrowse extends StandardLookup<EmployeeCourse> {
}