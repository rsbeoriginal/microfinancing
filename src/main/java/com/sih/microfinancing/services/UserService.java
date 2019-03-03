package com.sih.microfinancing.services;

import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.dto.UserDTO;

public interface UserService {
    UserDTO save(UserDTO userDTO);

    Boolean checkIfUserExists(String userId);

    UserDTO getDetails(String userId);

    ResponseDTO<Void> addAgriCredit(String userId, double agriCredit);
}
