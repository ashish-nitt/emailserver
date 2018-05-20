package com.sample.project.service;

import com.sample.project.Repository.AttachmentRepository;
import com.sample.project.Repository.EmailRepository;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ashish on 20-05-2018.
 */
@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;
}
