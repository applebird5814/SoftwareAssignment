package com.example.software.Entity.DiaryDetail;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Cover {
    @Id
    private String id;
    //@NotNull
    private String coverName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    @Override
    public String toString() {
        return "Cover{" +
                "id='" + id + '\'' +
                ", coverName='" + coverName + '\'' +
                '}';
    }
}
