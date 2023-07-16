package com.company.platform.service;

import com.company.platform.entity.Chapter;
import com.company.platform.entity.Course;
import com.company.platform.entity.Employee;

import java.util.List;

public interface ChapterService {
    String NAME = "platform_ChapterService";

    List<Chapter> getChapters(Course course);
}