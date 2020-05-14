package com.example.software.Entity.DiaryDetail;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class PaperColor {
    @Id
    private String id;
//    @NotNull
    private String color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "PaperColor{" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
