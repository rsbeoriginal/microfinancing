package com.sih.microfinancing.controller;

import com.sih.microfinancing.config.ApiConstants;
import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.dto.UserDTO;
import com.sih.microfinancing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(ApiConstants.USER)
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseDTO<UserDTO> save(@RequestBody UserDTO userDTO){
        ResponseDTO<UserDTO> responseDTO = new ResponseDTO<>();
        try {
            UserDTO userDTO1 = userService.save(userDTO);
            responseDTO.setSuccess(true);
            responseDTO.setResponse(userDTO1);
        }catch (Exception e){
            responseDTO.setSuccess(false);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    @GetMapping("/{userId}")
    public ResponseDTO<Boolean> checkIfUserExists(@PathVariable("userId") String userId) {
        ResponseDTO<Boolean> responseDTO = new ResponseDTO<>();
        try {
            responseDTO.setResponse(userService.checkIfUserExists(userId));
            responseDTO.setSuccess(true);
        }catch (Exception e){
            responseDTO.setSuccess(false);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

}
