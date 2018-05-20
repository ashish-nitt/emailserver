package com.sample.project.Repository;

import com.sample.project.model.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ashish on 20-05-2018.
 */
@Repository
@Transactional
public interface EmailRepository extends CrudRepository<Email, Long>{
}
