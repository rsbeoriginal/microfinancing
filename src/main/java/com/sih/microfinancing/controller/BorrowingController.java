package com.sih.microfinancing.controller;

import com.sih.microfinancing.config.ApiConstants;
import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.entity.BorrowerListing;
import com.sih.microfinancing.services.impl.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.BORROWING)
public class BorrowingController {

    @Autowired
    BorrowerService borrowerService;

    @PostMapping
    public ResponseDTO<BorrowerListing> addListing(@RequestBody BorrowerListing borrowerListing){
        ResponseDTO<BorrowerListing> responseDTO = new ResponseDTO<>();
        try {
            responseDTO.setResponse(borrowerService.addListing(borrowerListing));
            responseDTO.setSuccess(true);
        }catch (Exception e){
            responseDTO.setSuccess(false);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
}
