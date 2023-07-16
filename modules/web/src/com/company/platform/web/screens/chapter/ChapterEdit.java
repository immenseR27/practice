package com.company.platform.web.screens.chapter;

import com.haulmont.cuba.gui.screen.*;
import com.company.platform.entity.Chapter;

@UiController("platform_Chapter.edit")
@UiDescriptor("chapter-edit.xml")
@EditedEntityContainer("chapterDc")
@LoadDataBeforeShow
public class ChapterEdit extends StandardEditor<Chapter> {
}