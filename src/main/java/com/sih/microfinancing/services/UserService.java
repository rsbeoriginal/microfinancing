package com.sih.microfinancing.services;

import com.sih.microfinancing.dto.UserDTO;

public interface UserService {
    UserDTO save(UserDTO userDTO);

    Boolean checkIfUserExists(String userId);
}
