package com.sih.microfinancing.services.impl;

import com.sih.microfinancing.dto.UserDTO;
import com.sih.microfinancing.entity.User;
import com.sih.microfinancing.repository.UserRepository;
import com.sih.microfinancing.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        UserDTO userDTO1 = new UserDTO();
        BeanUtils.copyProperties(userRepository.save(user),userDTO1);
        return userDTO1;
    }

    @Override
    public Boolean checkIfUserExists(String userId) {
        if(userRepository.checkIfUserExists(userId)>0){
            return true;
        }
        return false;
    }
}
