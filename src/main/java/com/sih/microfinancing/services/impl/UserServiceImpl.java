package com.sih.microfinancing.services.impl;

import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.dto.UserDTO;
import com.sih.microfinancing.entity.User;
import com.sih.microfinancing.repository.UserRepository;
import com.sih.microfinancing.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
        user.setCreditScore(50);
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

    @Override
    public UserDTO getDetails(String userId) {
        User user = userRepository.findOne(userId);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }

    @Override
    public ResponseDTO<Void> addAgriCredit(String userId, double agriCredit) {
        User user = userRepository.findOne(userId);
        user.setAgriCredit(user.getAgriCredit()+agriCredit);
        userRepository.save(user);
        ResponseDTO<Void> responseDTO = new ResponseDTO<>();
        responseDTO.setSuccess(true);
        return responseDTO;
    }
}
