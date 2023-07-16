package com.company.platform.web.screens.course;

import com.company.platform.entity.Chapter;
import com.company.platform.entity.Course;
import com.company.platform.entity.Employee;
import com.company.platform.entity.EmployeeCourse;
import com.company.platform.service.EmployeeService;
import com.company.platform.web.screens.chapter.ChapterEdit;
import com.company.platform.web.screens.chapter.ChapterList;
import com.company.platform.web.screens.employeecourse.EmployeeCourseEdit;
import com.company.platform.web.screens.question.ChapterQuiz;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.gui.components.WebFileResource;
import com.vaadin.event.Action;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.File;
import java.util.List;
import java.util.function.Consumer;

@UiController("platform_CreatedCourses")
@UiDescriptor("created-courses.xml")
public class CreatedCourses extends StandardLookup<Course>{

    @Inject
    private EditorScreenFacet<Course, CourseEdit> courseCreationDialog;

    @Inject
    private Screens screens;

    @Inject
    private DataManager dataManager;

    @Inject
    private EmployeeService employeeService;

    @Inject
    private UiComponents uiComponents;



    Employee employee; //перенести
    @Inject
    private CollectionLoader<Course> courseDl;

    @Inject
    private VBoxLayout courseBox;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event){
        employee = employeeService.loadEmployee(null, null); //перенести
        courseDl.setParameter("employee", employee);
        showCourseList();
    }

    public void showCourseList(){

        courseDl.load();
        for (Course course : courseDl.getContainer().getItems()){
            LinkButton courseBtn = uiComponents.create(LinkButton.class);
            courseBtn.setCaption(course.getName());
            courseBtn.addClickListener(clickEvent -> {
                ChapterList chapterListScreen = screens.create(ChapterList.class);
                chapterListScreen.setCourse(course);
                Button addChapterBtn = uiComponents.create(Button.class);
                addChapterBtn.setCaption("Добавить");
                addChapterBtn.addClickListener(event -> {
                    Chapter chapter = dataManager.create(Chapter.class);
                    chapter.setCourse(course);
                    EditorScreenFacet<Chapter, ChapterEdit> chapterCreationDialog = chapterListScreen.getChapterCreationDialog();
                    chapterCreationDialog.setEntityProvider(() -> chapter);
                    chapterCreationDialog.show();
                });

                chapterListScreen.getButtonsPanel().add(addChapterBtn);
                screens.show(chapterListScreen);
            });
            courseBox.add(courseBtn);

        }
    }

    public void createNewCourse(){
        Course course = dataManager.create(Course.class);
        course.setAuthor(employee);
        course.setSize(0);
        courseCreationDialog.setEntityProvider(() -> course);
        courseCreationDialog.show();

    }

    @Subscribe("courseCreationDialog")
    public void onAfterCloseEvent(ScreenFacet.AfterCloseEvent event){
        courseBox.removeAll();
        showCourseList();
    }



}