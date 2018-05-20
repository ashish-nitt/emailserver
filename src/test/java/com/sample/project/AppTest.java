package com.sample.project;

import static org.junit.Assert.assertTrue;

import com.sample.project.Repository.AttachmentRepository;
import com.sample.project.Repository.EmailRepository;
import com.sample.project.Repository.UserRepository;
import com.sample.project.model.Attachment;
import com.sample.project.model.Email;
import com.sample.project.model.User;
import com.sample.project.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest 
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    AttachmentRepository attachmentRepository;

    @Test
    public void test()
    {
        //Test  Repo
        User user1 = userRepository.save(new User("user1@email.com", "user1", "pass1"));
        User user2 = userRepository.save(new User("user2@email.com", "user2", "pass2"));
        User user3 = userRepository.save(new User("user3@email.com", "user3", "pass3"));
        User user4 = userRepository.save(new User("user4@email.com", "user4", "pass4"));

        Attachment attachment = attachmentRepository.save(new Attachment("sadasdsds".getBytes(), "text"));

        Email email = new Email();
        email.setCopyOwner(user1);
        email.setFromUser(user1);
        email.addToUser(user3);
        email.addToUser(user4);
        email.setContent("Content");
        email.setSubject("Subject");
        email.addAttachments(attachment);
        email.setRead(false);
        email.setConversationTopic("Subject");
        email = emailRepository.save(email);
    }
}
