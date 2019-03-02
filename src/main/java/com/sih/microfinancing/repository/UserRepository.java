package com.sih.microfinancing.repository;

import com.sih.microfinancing.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {

    @Query(value = "SELECT COUNT(*) FROM user_ WHERE id = ?1",nativeQuery = true)
    int checkIfUserExists(String userId);
}
