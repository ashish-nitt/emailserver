package com.sample.project.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ashish on 20-05-2018.
 */
@Entity
@Data
@NoArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emailUniqueIdSequence")
    //@SequenceGenerator(name = "emailUniqueIdSequence", allocationSize = 50,initialValue = 1, sequenceName = "emailUniqueIdSequence")
    Long emailUniqueId;

    @ManyToOne
    @JoinColumn(name = "emailId")
    @NotNull
    User copyOwner;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "email_from",
            joinColumns = @JoinColumn(name = "emailUniqueId"),
            inverseJoinColumns = @JoinColumn(name = "emailId"))
    @NotNull
    User fromUser;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "email_to",
            joinColumns = @JoinColumn(name = "emailUniqueId"),
            inverseJoinColumns = @JoinColumn(name = "emailId"))
    @NotNull
    Set<User> toUser = new HashSet<>();

    String subject;
    String content;
    boolean isRead;
    String conversationTopic;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "email_attachment",
            joinColumns = @JoinColumn(name = "emailUniqueId"),
            inverseJoinColumns = @JoinColumn(name = "attachementId"))
    Set<Attachment> attachments = new HashSet<>();

    @CreationTimestamp
    LocalDateTime createTime;

    @UpdateTimestamp
    LocalDateTime updateTime;
}
