package com.example.software.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
    @Id
    private String id;
    @NotNull
    private String state;
    @NotNull
    private String urban;
    @NotNull
    private String postCode;
    @NotNull
    private String address;
    @NotNull
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrban() {
        return urban;
    }

    public void setUrban(String urban) {
        this.urban = urban;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", urban='" + urban + '\'' +
                ", postCode='" + postCode + '\'' +
                ", address='" + address + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
