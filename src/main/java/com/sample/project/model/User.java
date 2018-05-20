package com.sample.project.model;

import lombok.*;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ashish on 20-05-2018.
 */
@Entity
public class User {
    @Id
    @NotNull
    String emailId;

    @NotNull
    String userName;

    @NotNull
    String password;

    public User() {
        this.emailId = "";
        this.userName = "";
        this.password = "";
    }

    public User(@NotNull String emailId, @NotNull String userName, @NotNull String password) {
        this.emailId = emailId;
        this.userName = userName;
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
