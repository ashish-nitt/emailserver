package com.sample.project.service;

import com.sample.project.Repository.AttachmentRepository;
import com.sample.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserService {
    @Autowired
    UserRepository userRepository;
}
