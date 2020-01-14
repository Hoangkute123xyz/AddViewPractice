package com.hoangpro.addviewpractice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lesson {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("id_count_lesson")
    @Expose
    private Integer idCountLesson;
    @SerializedName("lesson_name")
    @Expose
    private String lessonName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("index_map")
    @Expose
    private Integer indexMap;
    @SerializedName("icon_show")
    @Expose
    private String iconShow;
    @SerializedName("icon_hidden")
    @Expose
    private String iconHidden;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIdCountLesson() {
        return idCountLesson;
    }

    public void setIdCountLesson(Integer idCountLesson) {
        this.idCountLesson = idCountLesson;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getIndexMap() {
        return indexMap;
    }

    public void setIndexMap(Integer indexMap) {
        this.indexMap = indexMap;
    }

    public String getIconShow() {
        return iconShow;
    }

    public void setIconShow(String iconShow) {
        this.iconShow = iconShow;
    }

    public String getIconHidden() {
        return iconHidden;
    }

    public void setIconHidden(String iconHidden) {
        this.iconHidden = iconHidden;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
