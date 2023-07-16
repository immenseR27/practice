package com.company.platform.web.screens.employeechapter;

import com.haulmont.cuba.gui.screen.*;
import com.company.platform.entity.EmployeeChapter;

@UiController("platform_EmployeeChapter.edit")
@UiDescriptor("employee-chapter-edit.xml")
@EditedEntityContainer("employeeChapterDc")
@LoadDataBeforeShow
public class EmployeeChapterEdit extends StandardEditor<EmployeeChapter> {
}