package com.example.software.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    private String id;
    @NotNull
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]{3,15}")
    @Column(name = "username", unique = true)
    private String username;
    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]{6,15}")
    private String password;

    @NotNull
    private String type;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
