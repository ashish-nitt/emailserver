package com.sample.project;

import static org.junit.Assert.assertTrue;

import com.sample.project.Repository.UserRepository;
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

/**
 * Unit test for simple App.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest 
{
    @Autowired
    UserRepository userRepository;

    @Test
    public void shouldAnswerWithTrue()
    {
        User user = new User("user1@email.com", "user1", "pass1");
        userRepository.save(user);
    }
}
