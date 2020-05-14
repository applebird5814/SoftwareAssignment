package com.example.software.Entity.DiaryDetail;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TypeOfPaper {
    @Id
    private String id;
 //   @NotNull
    private String typeOfPaper;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeOfPaper() {
        return typeOfPaper;
    }

    public void setTypeOfPaper(String typeOfPaper) {
        this.typeOfPaper = typeOfPaper;
    }

    @Override
    public String toString() {
        return "TypeOfPaper{" +
                "id='" + id + '\'' +
                ", typeOfPaper='" + typeOfPaper + '\'' +
                '}';
    }
}
