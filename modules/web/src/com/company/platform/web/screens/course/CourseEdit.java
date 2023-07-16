package com.company.platform.web.screens.course;

import com.company.platform.web.screens.chapter.ChapterList;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.platform.entity.Course;

import javax.inject.Inject;
import java.util.function.Consumer;

@UiController("platform_Course.edit")
@UiDescriptor("course-edit.xml")
@EditedEntityContainer("courseDc")
@LoadDataBeforeShow
public class CourseEdit extends StandardEditor<Course> {
}