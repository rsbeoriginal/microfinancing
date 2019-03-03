package com.sih.microfinancing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sih.microfinancing.config.ApiConstants;
import com.sih.microfinancing.dto.BorrowerListingDTO;
import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.entity.BorrowerListing;
import com.sih.microfinancing.entity.TransactionRequest;
import com.sih.microfinancing.services.BorrowerService;

@CrossOrigin
@RestController
@RequestMapping(ApiConstants.BORROWING)
public class BorrowingController {


    @Autowired
    BorrowerService borrowerService;

    @PostMapping("/addListing")
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


    @GetMapping("/getAllListing")
    public ResponseDTO<List<BorrowerListingDTO>> getAllListing(){
        ResponseDTO<List<BorrowerListingDTO>> responseDTO;
        try {
            responseDTO = borrowerService.getListing();

        }catch (Exception e){
            responseDTO = new ResponseDTO<>();
            responseDTO.setSuccess(false);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    @PostMapping("/getListing/{borrowerId}")
    public ResponseDTO<List<BorrowerListing>> getListingById(@PathVariable String borrowerId){
        ResponseDTO<List<BorrowerListing>> responseDTO = new ResponseDTO<>();
        try {
            responseDTO.setResponse(borrowerService.getListingById(borrowerId));
            responseDTO.setSuccess(true);
        }catch (Exception e){
            responseDTO.setSuccess(false);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }


    @PostMapping("/getListingById/{id}")
    public ResponseDTO<BorrowerListing> getListing(@PathVariable String id){
        ResponseDTO<BorrowerListing> responseDTO = new ResponseDTO<>();
        try {
            responseDTO.setResponse(borrowerService.getListing(id));
            responseDTO.setSuccess(true);
        }catch (Exception e){
            responseDTO.setSuccess(false);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

    @PostMapping("/payLender/{transactionId}/{ammount}")
    public ResponseDTO<BorrowerListing> payLender(@PathVariable String transactionId, @PathVariable double ammount){
        ResponseDTO<BorrowerListing> responseDTO;
        try {
            responseDTO = borrowerService.payLender(transactionId, ammount);

        }catch (Exception e){
            responseDTO = new ResponseDTO<>();
            responseDTO.setSuccess(false);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }




}
