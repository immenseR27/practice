package com.company.platform.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "PLATFORM_QUESTION")
@Entity(name = "platform_Question")
public class Question extends StandardEntity {
    private static final long serialVersionUID = -2739871623181689214L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHAPTER_ID")
    private Chapter chapter;

    @Lob
    @Column(name = "TEXT")
    private String text;

    @Lob
    @Column(name = "VARIANT1")
    private String variant1;

    @Lob
    @Column(name = "VARIANT2")
    private String variant2;

    @Lob
    @Column(name = "VARIANT3")
    private String variant3;

    @Lob
    @Column(name = "VARIANT4")
    private String variant4;

    @Column(name = "ANSWER")
    private Integer answer;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVariant1() {
        return variant1;
    }

    public void setVariant1(String variant1) {
        this.variant1 = variant1;
    }

    public String getVariant2() {
        return variant2;
    }

    public void setVariant2(String variant2) {
        this.variant2 = variant2;
    }

    public String getVariant3() {
        return variant3;
    }

    public void setVariant3(String variant3) {
        this.variant3 = variant3;
    }

    public String getVariant4() {
        return variant4;
    }

    public void setVariant4(String variant4) {
        this.variant4 = variant4;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}