package com.company.platform.service;

import com.company.platform.entity.Chapter;
import com.company.platform.entity.Question;

import java.util.List;

public interface QuestionService {
    String NAME = "platform_QuestionService";

    List<Question> downloadQuestions(Chapter chapter);
}