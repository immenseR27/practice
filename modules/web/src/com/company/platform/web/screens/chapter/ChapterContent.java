package com.company.platform.web.screens.chapter;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.BrowserFrame;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("platform_ChapterContent")
@UiDescriptor("chapter-content.xml")
public class ChapterContent extends Screen {

    BrowserFrame browserFrame;

    @Inject
    private VBoxLayout content;
    @Inject
    private DataManager dataManager;
    @Inject
    private UiComponents uiComponents;

    public void setBrowserFrame(BrowserFrame browserFrame) {
        this.browserFrame = browserFrame;
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event){
        browserFrame.setWidth("1600");
        browserFrame.setHeight("1000");
        content.add(browserFrame);
    }

    public void saveCoursePage(){

//        HTMLDocument htmlDocument = uiComponents.create(HTMLDocument.class);
//        htmlDocument.getBody
    }
}