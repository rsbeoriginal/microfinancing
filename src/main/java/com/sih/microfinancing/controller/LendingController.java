package com.sih.microfinancing.controller;

import com.sih.microfinancing.config.ApiConstants;
import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.entity.LenderListing;
import com.sih.microfinancing.services.LenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(ApiConstants.LENDING)
public class LendingController {

    @Autowired
    LenderService lenderService;

    @PostMapping
    public ResponseDTO<LenderListing> addListing(@RequestBody LenderListing lenderListing){
        ResponseDTO<LenderListing> responseDTO = new ResponseDTO<>();
        try {
            responseDTO.setResponse(lenderService.addListing(lenderListing));
            responseDTO.setSuccess(true);
        }catch (Exception e){
            responseDTO.setSuccess(false);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }





}
