package com.company.platform.web.screens.question;

import com.company.platform.entity.Chapter;
import com.company.platform.entity.Employee;
import com.company.platform.entity.EmployeeCourse;
import com.company.platform.entity.Question;
import com.company.platform.service.ChapterService;
import com.company.platform.service.EmployeeChapterService;
import com.company.platform.service.EmployeeService;
import com.company.platform.service.QuestionService;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.RadioButtonGroup;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.web.theme.HaloTheme;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@UiController("platform_ChapterQuiz")
@UiDescriptor("chapter-quiz.xml")
public class ChapterQuiz extends Screen {

    Chapter chapter;

    @Inject
    private VBoxLayout questionsVBox;

    @Inject
    private Dialogs dialogs;

    @Inject
    private UiComponents uiComponents;

    @Inject
    private QuestionService questionService;

    @Inject
    EmployeeService employeeService;

    Map<RadioButtonGroup<Integer>, Integer> questionAnswerHashMap = new HashMap<>();

    @Inject
    private EmployeeChapterService employeeChapterService;

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    @Subscribe
    public void afterShow(AfterShowEvent event){
        List<Question> questions = questionService.downloadQuestions(chapter);

        for (int i = 0; i < questions.size(); i++){
            Question question = questions.get(i);

            Label<String> questionLabel =  uiComponents.create(Label.class);
            questionLabel.setStyleName(HaloTheme.LABEL_BOLD);
            questionLabel.setWidthFull();
            uiComponents.create(Label.class);
            questionLabel.setValue((i+1) + ". " + question.getText());

            Map<String, Integer> variantsHashMap = new HashMap<>();
            variantsHashMap.put(question.getVariant1(), 1);
            variantsHashMap.put(question.getVariant2(), 2);
            variantsHashMap.put(question.getVariant3(), 3);
            variantsHashMap.put(question.getVariant4(), 4);

            RadioButtonGroup<Integer> radioButtonGroup = uiComponents.create(RadioButtonGroup.class);
            questionAnswerHashMap.put(radioButtonGroup, question.getAnswer());
            radioButtonGroup.setOptionsMap(variantsHashMap);
            radioButtonGroup.setWidthFull();

            questionsVBox.add(questionLabel, radioButtonGroup);
        }

        Button sendButton = uiComponents.create(Button.class);
        sendButton.setCaption("Завершить и отправить");
        sendButton.addClickListener(clickEvent -> {

            for (Map.Entry<RadioButtonGroup<Integer>, Integer> entry : questionAnswerHashMap.entrySet()){
                if (entry.getKey().getValue() == null){
                    dialogs.createMessageDialog().withCaption("Сообщение").withMessage("Вы ответили не на все вопросы!").show();
                    return;
                }
            }

            int right = 0;
            int count = questionAnswerHashMap.size();
            for (Map.Entry<RadioButtonGroup<Integer>, Integer> entry : questionAnswerHashMap.entrySet()){
                if (entry.getKey().getValue().equals(entry.getValue())){
                    right += 1;
                }
            }
            Label<String> resultLabel =  uiComponents.create(Label.class);
            double score = (double) right/(double) count*100;
            Employee employee = employeeService.loadEmployee(null, null); //перенести
            employeeChapterService.updateScore(employee, chapter, score);
            resultLabel.setValue(String.format("Решено правильно: %d/%d (%.2f%%)", right, count, score));
            questionsVBox.removeAll();
            questionsVBox.add(resultLabel);
        });

        questionsVBox.add(sendButton);
    }
}