package com.example.software.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class DiaryOrder {
    @Id
    private int id;
    @NotNull
    private String userId;
    @NotNull
    private String address;
    @NotNull
    private String time;
    @NotNull
    private String deliverOption;
    @NotNull
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDeliverOption() {
        return deliverOption;
    }

    public void setDeliverOption(String deliverOption) {
        this.deliverOption = deliverOption;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", address='" + address + '\'' +
                ", time='" + time + '\'' +
                ", deliverOption='" + deliverOption + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
