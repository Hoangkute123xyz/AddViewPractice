package com.hoangpro.addviewpractice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LessonObject {
    @SerializedName("Err")
    @Expose
    private Object err;
    @SerializedName("Lessons")
    @Expose
    private List<Lesson> lessons = null;

    public Object getErr() {
        return err;
    }

    public void setErr(Object err) {
        this.err = err;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
