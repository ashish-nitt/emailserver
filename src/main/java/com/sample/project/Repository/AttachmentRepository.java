package com.sample.project.Repository;

import com.sample.project.model.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Lob;

/**
 * Created by Ashish on 20-05-2018.
 */
@Repository
@Transactional
public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
}
