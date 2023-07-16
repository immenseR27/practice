package com.company.platform.web.screens.question;

import com.haulmont.cuba.gui.screen.*;
import com.company.platform.entity.Question;

@UiController("platform_Question.edit")
@UiDescriptor("question-edit.xml")
@EditedEntityContainer("questionDc")
@LoadDataBeforeShow
public class QuestionEdit extends StandardEditor<Question> {
}