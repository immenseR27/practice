package com.company.platform.web.screens.employee;

import com.company.platform.entity.Course;
import com.company.platform.entity.Employee;
import com.company.platform.entity.EmployeeCourse;
import com.company.platform.web.screens.employeecourse.EmployeeCourseEdit;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.EditorScreenFacet;
import com.haulmont.cuba.gui.components.ScreenFacet;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.awt.*;
import java.util.function.Supplier;

@UiController("platform_AllEmployees")
@UiDescriptor("all-employees.xml")
@LookupComponent("employeesTable")
public class AllEmployees extends StandardLookup<Employee> {
    @Inject
    protected DataManager dataManager;
    @Inject
    private CollectionLoader<Employee> employeeDl;

    @Inject
    private CollectionLoader<Course> courseDl;

    @Inject
    private EditorScreenFacet<EmployeeCourse, EmployeeCourseEdit> courseAdditionDialog;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        employeeDl.load();
        courseDl.setParameter("employee", employeeDl.getContainer().getItems().get(0));
        courseDl.load();
    }

    @Subscribe(id = "employeeDc", target = Target.DATA_CONTAINER)
    public void onEmployeeDcItemChange(InstanceContainer.ItemChangeEvent<Employee> event) {
        courseDl.setParameter("employee", event.getItem());
        courseDl.load();
    }

    public void addCourseToEmployee(){
        EmployeeCourse employeeCourse = dataManager.create(EmployeeCourse.class);
        employeeCourse.setEmployee(employeeDl.getContainer().getItem());
        courseAdditionDialog.setEntityProvider(() -> employeeCourse);
        courseAdditionDialog.show();
    }

    @Subscribe("courseAdditionDialog")
    public void onAfterCloseEvent(EditorScreenFacet.AfterCloseEvent event){
        courseDl.load();
    }

}