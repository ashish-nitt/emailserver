package com.sample.project.Repository;

import com.sample.project.model.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Lob;

/**
 * Created by Ashish on 20-05-2018.
 */
@Repository
public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
}
