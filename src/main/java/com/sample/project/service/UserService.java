package com.sample.project.service;

import com.sample.project.Repository.AttachmentRepository;
import com.sample.project.Repository.UserRepository;
import com.sample.project.model.Email;
import com.sample.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ashish on 20-05-2018.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByEmailId(String emailId) {
        return userRepository.findUserByEmailId(emailId);
    }
}
