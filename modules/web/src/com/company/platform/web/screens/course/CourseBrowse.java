package com.company.platform.web.screens.course;

import com.company.platform.entity.Chapter;
import com.company.platform.entity.Employee;
import com.company.platform.entity.EmployeeCourse;
import com.company.platform.service.ChapterService;
import com.company.platform.service.CourseService;
import com.company.platform.service.EmployeeCourseService;
import com.company.platform.service.EmployeeService;
import com.company.platform.web.screens.chapter.ChapterList;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.platform.entity.Course;
import com.haulmont.cuba.gui.screen.LookupComponent;
import org.checkerframework.checker.units.qual.C;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@UiController("platform_Course.browse")
@UiDescriptor("course-browse.xml")
@LookupComponent("coursesTable")
@LoadDataBeforeShow
public class CourseBrowse extends StandardLookup<Course> {

    @Inject
    private Screens screens;

    @Named("chaptersTabSheet.coursesListTab")
    private VBoxLayout coursesListTab;

    @Inject
    private EmployeeCourseService employeeCourseService;

    @Inject
    private ChapterService chapterService;

    @Inject
    private UiComponents uiComponents;
    @Inject
    private Logger log;
    @Inject
    private EmployeeService employeeService;

    @Inject
    private CourseService courseService;

    @Subscribe
    public void onInit(InitEvent event) {
//        Image image = uiComponents.create(Image.class);
//        image.setSource(RelativePathResource.class)
//                .setPath("VAADIN/course_icons/one.jpeg");
//        image.setWidth("100px");
//        image.addClickListener(clickEvent -> System.out.println("BLABLABLA"));

        Employee employee = employeeService.loadEmployee(null, null); //перенести
        employee.setEmployeeCourses(employeeCourseService.getEmployeeCourses(employee));
        List<EmployeeCourse> employeeCourses = employee.getEmployeeCourses();
        List<Course> courses = courseService.getCourses(employeeCourses);

        GridLayout coursesGrid = uiComponents.create(GridLayout.class);
        coursesListTab.add(coursesGrid);
        coursesGrid.setColumns(4);
        coursesGrid.setRows(courses.size());
        for (int i = 0; i < courses.size(); i++){
            Course course = courses.get(i);
            Button courseButton = uiComponents.create(Button.class);
            courseButton.setCaption(course.getName());
            courseButton.addClickListener(clickEvent -> {
                ChapterList chapterListScreen = screens.create(ChapterList.class);
                chapterListScreen.setCourse(course);
                screens.show(chapterListScreen);
            });
            coursesGrid.add(courseButton, i%4, i/4);
        }
    }
}