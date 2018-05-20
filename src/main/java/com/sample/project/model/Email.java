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
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emailUniqueIdSequence")
    //@SequenceGenerator(name = "emailUniqueIdSequence", allocationSize = 50,initialValue = 1, sequenceName = "emailUniqueIdSequence")
    Long emailUniqueId;

    @ManyToOne(cascade = {})
    @JoinTable(name = "email_owner",
            joinColumns = @JoinColumn(name = "emailUniqueId"),
            inverseJoinColumns = @JoinColumn(name = "emailId"))
    User copyOwner;

    @ManyToOne(cascade = {})
    @JoinTable(name = "email_from",
            joinColumns = @JoinColumn(name = "emailUniqueId"),
            inverseJoinColumns = @JoinColumn(name = "emailId"))
    @NotNull
    User fromUser;

    @ManyToMany(cascade = {})
    @JoinTable(name = "email_to",
            joinColumns = @JoinColumn(name = "emailUniqueId"),
            inverseJoinColumns = @JoinColumn(name = "emailId"))
    @NotNull
    Set<User> toUsers = new HashSet<>();

    @NotNull
    String subject;

    @NotNull
    String content;

    @NotNull
    Boolean isRead;

    @NotNull
    String conversationTopic;

    @ManyToMany(cascade = {})
    @JoinTable(name = "email_attachment",
            joinColumns = @JoinColumn(name = "emailUniqueId"),
            inverseJoinColumns = @JoinColumn(name = "attachementId"))
    Set<Attachment> attachments = new HashSet<>();

    @CreationTimestamp
    LocalDateTime createTime;

    @UpdateTimestamp
    LocalDateTime updateTime;

    public Long getEmailUniqueId() {
        return emailUniqueId;
    }

    public void setEmailUniqueId(Long emailUniqueId) {
        this.emailUniqueId = emailUniqueId;
    }

    public User getCopyOwner() {
        return copyOwner;
    }

    public void setCopyOwner(User copyOwner) {
        this.copyOwner = copyOwner;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public Set<User> getToUsers() {
        return toUsers;
    }

    public void setToUsers(Set<User> toUser) {
        this.toUsers = toUser;
    }

    public void addToUser(User toUser) {
        this.toUsers.add(toUser);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getConversationTopic() {
        return conversationTopic;
    }

    public void setConversationTopic(String conversationTopic) {
        this.conversationTopic = conversationTopic;
    }

    public Set<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
    }

    public void addAttachments(Attachment attachment) {
        this.attachments.add(attachment);
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
