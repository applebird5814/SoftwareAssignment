package com.example.software.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Diary {
    @Id
    private int id;
    @NotNull
    private String paperColor;
    @NotNull
    private String cover;
    @NotNull
    private String typeOfPaper;

    private String customizableText;

    private int orderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
