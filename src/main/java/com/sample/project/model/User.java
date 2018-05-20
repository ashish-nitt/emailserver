package com.sample.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
public class User {
    @Id
    @NotNull
    String emailId;

    @NotNull
    String userName;

    @NotNull
    String password;

    @OneToMany
    @JoinColumn(name = "emailUniqueId")
    Set<Email> incomingEmails = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "emailUniqueId")
    Set<Email> sentEmails = new HashSet<>();
}
