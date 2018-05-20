package com.sample.project;

import static org.junit.Assert.assertTrue;

import com.sample.project.Repository.AttachmentRepository;
import com.sample.project.Repository.EmailRepository;
import com.sample.project.Repository.UserRepository;
import com.sample.project.model.Attachment;
import com.sample.project.model.Email;
import com.sample.project.model.User;
import com.sample.project.service.AttachmentService;
import com.sample.project.service.EmailService;
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
    UserService userService;

    @Autowired
    EmailService emailService;

    @Autowired
    AttachmentService attachmentService;

    @Test
    public void test()
    {
        //Test  Repo
        userService.createUser(new User("user1@email.com", "user1", "pass1"));
        userService.createUser(new User("user2@email.com", "user2", "pass2"));
        userService.createUser(new User("user3@email.com", "user3", "pass3"));
        userService.createUser(new User("user4@email.com", "user4", "pass4"));

        emailService.sendEmail("user1@email.com",
                new String[] {"user3@email.com", "user4@email.com"},
                "subject1",
                "content1");
        emailService.sendEmail("user2@email.com",
                new String[] {"user3@email.com", "user4@email.com"},
                "subject2",
                "content2",
                "asdsdsadsad".getBytes());
    }
}
