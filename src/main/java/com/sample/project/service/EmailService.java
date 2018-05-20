package com.sample.project.service;

import com.sample.project.Repository.AttachmentRepository;
import com.sample.project.Repository.EmailRepository;
import com.sample.project.model.Attachment;
import com.sample.project.model.Email;
import com.sample.project.model.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ashish on 20-05-2018.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmailService {
    @Autowired
    EmailRepository emailRepository;

    @Autowired
    UserService userService;

    @Autowired
    AttachmentService attachmentService;

    protected Email createEmail(Email email) {
        return emailRepository.save(email);
    }

    public Email findEmailByEmailUniqueId(Long emailUniqueId) {
        return emailRepository.findEmailByEmailUniqueId(emailUniqueId);
    }

    public void sendEmail(String from, String[] to, String subject, String content) {
        Email sentEmail = new Email();
        User fromUser = userService.findUserByEmailId(from);
        sentEmail.setCopyOwner(fromUser);
        sentEmail.setFromUser(fromUser);
        Set<User> toUsers = new HashSet<>();
        for(String toUser : to)
            toUsers.add(userService.findUserByEmailId(toUser));
        sentEmail.setToUsers(toUsers);
        sentEmail.setContent(content);
        sentEmail.setSubject(subject);
        sentEmail.setRead(true);
        sentEmail.setConversationTopic(subject);
        emailRepository.save(sentEmail);
        for (User toUser : toUsers) {
            Email receivedEmail = new Email();
            receivedEmail.setCopyOwner(toUser);
            receivedEmail.setFromUser(fromUser);
            receivedEmail.setToUsers(toUsers);
            receivedEmail.setContent(content);
            receivedEmail.setSubject(subject);
            receivedEmail.setRead(false);
            receivedEmail.setConversationTopic(subject);
            emailRepository.save(receivedEmail);
        }
    }
    public void sendEmail(String from, String[] to, String subject, String content, byte[] attachmentContent) {
        Attachment attachment = attachmentService.createAttachment(new Attachment(attachmentContent, "text"));
        Email sentEmail = new Email();
        User fromUser = userService.findUserByEmailId(from);
        sentEmail.setCopyOwner(fromUser);
        sentEmail.setFromUser(fromUser);
        Set<User> toUsers = new HashSet<>();
        for(String toUser : to)
            toUsers.add(userService.findUserByEmailId(toUser));
        sentEmail.setToUsers(toUsers);
        sentEmail.setContent(content);
        sentEmail.setSubject(subject);
        sentEmail.setRead(true);
        sentEmail.setConversationTopic(subject);
        sentEmail.addAttachments(attachment);
        emailRepository.save(sentEmail);
        for (User toUser : toUsers) {
            Email receivedEmail = new Email();
            receivedEmail.setCopyOwner(toUser);
            receivedEmail.setFromUser(fromUser);
            receivedEmail.setToUsers(toUsers);
            receivedEmail.setContent(content);
            receivedEmail.setSubject(subject);
            receivedEmail.setRead(false);
            receivedEmail.setConversationTopic(subject);
            receivedEmail.addAttachments(attachment);
            emailRepository.save(receivedEmail);
        }
    }
}
