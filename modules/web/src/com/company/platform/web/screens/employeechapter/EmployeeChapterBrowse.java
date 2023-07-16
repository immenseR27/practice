package com.company.platform.web.screens.employeechapter;

import com.haulmont.cuba.gui.screen.*;
import com.company.platform.entity.EmployeeChapter;

@UiController("platform_EmployeeChapter.browse")
@UiDescriptor("employee-chapter-browse.xml")
@LookupComponent("employeeChaptersTable")
@LoadDataBeforeShow
public class EmployeeChapterBrowse extends StandardLookup<EmployeeChapter> {
}