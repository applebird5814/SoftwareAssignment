package com.example.software.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Diary {
    @Id
    private String id;
    @NotNull
    private String paperColor;
    @NotNull
    private String cover;
    @NotNull
    private String typeOfPaper;
    @NotNull
    private String customizableText;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaperColor() {
        return paperColor;
    }

    public void setPaperColor(String paperColor) {
        this.paperColor = paperColor;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTypeOfPaper() {
        return typeOfPaper;
    }

    public void setTypeOfPaper(String typeOfPaper) {
        this.typeOfPaper = typeOfPaper;
    }

    public String getCustomizableText() {
        return customizableText;
    }

    public void setCustomizableText(String customizableText) {
        this.customizableText = customizableText;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id='" + id + '\'' +
                ", paperColor='" + paperColor + '\'' +
                ", cover='" + cover + '\'' +
                ", typeOfPaper='" + typeOfPaper + '\'' +
                ", customizableText='" + customizableText + '\'' +
                '}';
    }
}
