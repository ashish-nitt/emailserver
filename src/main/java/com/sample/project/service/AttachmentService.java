package com.sample.project.service;

import com.sample.project.Repository.AttachmentRepository;
import com.sample.project.model.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Ashish on 20-05-2018.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;

    protected Attachment createAttachment(Attachment attachment){
        return attachmentRepository.save(attachment);
    }

    protected Attachment findAttachmentById(Long attachmentId) {
        return attachmentRepository.findAttachmentByAttachmentId(attachmentId);
    }
}
