package com.company.platform.service;

import com.company.platform.entity.Chapter;
import com.company.platform.entity.Course;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(ChapterService.NAME)
public class ChapterServiceBean implements ChapterService {

    @Inject
    private DataManager dataManager;

    @Override
    public List<Chapter> getChapters(Course course) {
        return dataManager.load(Chapter.class)
                .query("select c from platform_Chapter c where c.course = :course")
                .parameter("course", course)
                .list();
    }
}