package com.sample.project.Repository;

import com.sample.project.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ashish on 20-05-2018.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
}
