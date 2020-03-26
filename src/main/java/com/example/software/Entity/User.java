package com.example.software.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "user")
public class User {
    @Id
    private String id;
    @NotNull
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]{3,15}")
    @Column(name="username",unique = true)
    private String username;
    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]{6,15}")
    private String password;
    @NotNull
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]{3,15}")
    private String screenName;
    @NotNull
    @Pattern(regexp = "[0-9]{11}")
    private String telephone;
    @Email
    @Column(name="mail_address",unique = true)
    private String mailAddress;

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
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", screenName='" + screenName + '\'' +
                ", telephone=" + telephone +
                ", mailAddress='" + mailAddress + '\'' +
                '}';
    }

    public String getScreenName() {
        return screenName;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}