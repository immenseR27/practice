package com.company.platform.service;

import com.company.platform.entity.Chapter;
import com.company.platform.entity.Question;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(QuestionService.NAME)
public class QuestionServiceBean implements QuestionService {

    @Inject
    private DataManager dataManager;

    @Override
    public List<Question> downloadQuestions(Chapter chapter) {
        return dataManager.load(Question.class)
                .query("select q from platform_Question q where q.chapter = :chapter")
                .parameter("chapter", chapter)
                .list();
    }
}