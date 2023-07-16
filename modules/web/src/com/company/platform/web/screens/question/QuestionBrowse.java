package com.company.platform.web.screens.question;

import com.haulmont.cuba.gui.screen.*;
import com.company.platform.entity.Question;

@UiController("platform_Question.browse")
@UiDescriptor("question-browse.xml")
@LookupComponent("questionsTable")
@LoadDataBeforeShow
public class QuestionBrowse extends StandardLookup<Question> {
}