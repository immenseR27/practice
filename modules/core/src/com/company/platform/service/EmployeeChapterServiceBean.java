package com.company.platform.service;

import com.company.platform.entity.Chapter;
import com.company.platform.entity.Employee;
import com.company.platform.entity.EmployeeChapter;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EntityStates;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(EmployeeChapterService.NAME)
public class EmployeeChapterServiceBean implements EmployeeChapterService {

    @Inject
    private DataManager dataManager;

    @Override
    public void updateScore(Employee employee, Chapter chapter, Double newScore) {

        List<EmployeeChapter> employeeChapterList = dataManager.load(EmployeeChapter.class)
                .query("select ec from platform_EmployeeChapter ec " +
                        "where ec.employee = :employee and ec.chapter = :chapter")
                .parameter("employee", employee)
                .parameter("chapter", chapter)
                .list();

        if (employeeChapterList.isEmpty() ){
            EmployeeChapter employeeChapter = dataManager.create(EmployeeChapter.class);
            employeeChapter.setEmployee(employee);
            employeeChapter.setChapter(chapter);
            employeeChapter.setScore(newScore);
            dataManager.commit(employeeChapter);
        }
        else {
            EmployeeChapter employeeChapter = employeeChapterList.get(0);
            if (newScore > employeeChapter.getScore()){
                employeeChapter.setScore(newScore);
                dataManager.commit(employeeChapter);
            }
        }
    }
}