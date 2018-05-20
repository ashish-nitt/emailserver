package com.sample.project.Repository;

import com.sample.project.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ashish on 20-05-2018.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findUserByEmailId(String emailId);
}
