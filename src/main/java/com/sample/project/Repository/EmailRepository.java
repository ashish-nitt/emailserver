package com.sample.project.Repository;

import com.sample.project.model.Email;
import com.sample.project.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ashish on 20-05-2018.
 */
@Repository
public interface EmailRepository extends CrudRepository<Email, Long> {
    Email findEmailByEmailUniqueId(Long emailUniqueId);
    List<Email> findAllByCopyOwner(User user);
    List<Email> findAllByCopyOwnerAndFromUser(User user, User from);
    List<Email> findAllByCopyOwnerAndToUsers(User user, User to);
}
