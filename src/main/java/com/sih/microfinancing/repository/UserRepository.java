package com.sih.microfinancing.repository;

import com.sih.microfinancing.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {

    @Query("SELECT COUNT(*) FROM User WHERE id = ?1")
    int checkIfUserExists(String userId);
}
