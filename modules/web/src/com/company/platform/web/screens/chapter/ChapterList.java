package com.company.platform.web.screens.chapter;

import com.company.platform.entity.Chapter;
import com.company.platform.entity.Course;
import com.company.platform.service.ChapterService;
import com.company.platform.web.screens.question.ChapterQuiz;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.web.gui.components.WebFileResource;
import com.haulmont.cuba.web.theme.HaloTheme;

import javax.inject.Inject;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

@UiController("platform_ChapterList")
@UiDescriptor("chapter-list.xml")
public class ChapterList extends Screen {

    private Course course;

    @Inject
    private EditorScreenFacet<Chapter, ChapterEdit> chapterCreationDialog;

    @Inject
    private VBoxLayout chapterListVBox;

    @Inject
    private ButtonsPanel buttonsPanel;

    @Inject
    private UiComponents uiComponents;

    @Inject
    private ChapterService chapterService;

    @Inject
    private Screens screens;

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public ButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public EditorScreenFacet<Chapter, ChapterEdit> getChapterCreationDialog() {
        return chapterCreationDialog;
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        List<Chapter> chapters = chapterService.getChapters(course);
        for (Chapter chapter : chapters){
            Button chapterButton = createButton(chapter.getName());
            chapterButton.addClickListener(event1 -> {
                BrowserFrame browserFrame = uiComponents.create(BrowserFrame.class);
                browserFrame.setSource(new WebFileResource().setFile(new File("D:/page.html")));
                ChapterContent chapterContent = screens.create(ChapterContent.class);
                chapterContent.setBrowserFrame(browserFrame);
                chapterContent.show();
            });
            Button quizButton = createButton("Тест по разделу");
            quizButton.addClickListener(clickEvent -> {
                ChapterQuiz chapterQuizScreen = screens.create(ChapterQuiz.class);
                chapterQuizScreen.setChapter(chapter);
                chapterQuizScreen.show();
            });
            chapterListVBox.add(chapterButton, quizButton);
        }
        Button examButton = createButton("Итоговый экзамен");
        examButton.addClickListener(clickEvent -> {

        });
        chapterListVBox.add(examButton);
    }

    public Button createButton(String caption){
        Button button = uiComponents.create(Button.class);
        button.setCaption(caption);
        button.setStyleName(HaloTheme.BUTTON_BORDERLESS);
        return button;
    }
}