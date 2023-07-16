package com.company.platform.web.screens.employeecourse;

import com.haulmont.cuba.gui.components.EditorScreenFacet;
import com.haulmont.cuba.gui.components.ScreenFacet;
import com.haulmont.cuba.gui.screen.*;
import com.company.platform.entity.EmployeeCourse;

@UiController("platform_EmployeeCourse.edit")
@UiDescriptor("employee-course-edit.xml")
@EditedEntityContainer("employeeCourseDc")
@LoadDataBeforeShow
public class EmployeeCourseEdit extends StandardEditor<EmployeeCourse> {

}