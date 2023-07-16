package com.company.platform.service;

import com.company.platform.entity.Chapter;
import com.company.platform.entity.Employee;

public interface EmployeeChapterService {
    String NAME = "platform_EmployeeChapterService";

    void updateScore(Employee employee, Chapter chapter, Double score);

}