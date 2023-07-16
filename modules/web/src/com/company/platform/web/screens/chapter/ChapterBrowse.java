package com.company.platform.web.screens.chapter;

import com.company.platform.entity.Question;
import com.company.platform.service.QuestionService;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.platform.entity.Chapter;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.cuba.web.theme.HaloTheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.*;

@UiController("platform_Chapter.browse")
@UiDescriptor("chapter-browse.xml")
@LookupComponent("chaptersTable")
@LoadDataBeforeShow
public class ChapterBrowse extends StandardLookup<Chapter> {

}