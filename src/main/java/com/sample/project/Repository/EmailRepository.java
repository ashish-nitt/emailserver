package com.sample.project.Repository;

import com.sample.project.model.Email;
import com.sample.project.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ashish on 20-05-2018.
 */
@Repository
public interface EmailRepository extends CrudRepository<Email, Long> {
    Email findEmailByEmailUniqueId(Long emailUniqueId);
}
