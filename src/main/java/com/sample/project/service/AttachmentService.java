package com.sample.project.service;

import com.sample.project.Repository.AttachmentRepository;
import com.sample.project.model.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Ashish on 20-05-2018.
 */
@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
}
