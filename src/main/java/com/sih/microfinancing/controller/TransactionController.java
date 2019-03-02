package com.sih.microfinancing.controller;

import java.util.List;

import com.sih.microfinancing.config.ApiConstants;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.entity.TransactionComplete;
import com.sih.microfinancing.entity.TransactionInProgress;
import com.sih.microfinancing.entity.TransactionRequest;
import com.sih.microfinancing.repository.TransactionRequestRepository;
import com.sih.microfinancing.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.TransactionalRepositoryFactoryBeanSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(ApiConstants.TRANSACTION)
public class TransactionController {

  @Autowired
  TransactionService transactionService;

  @Autowired
  TransactionRequestRepository transactionRequestRepository;

  @PostMapping("/createLenderRequest")
  public ResponseDTO<List<TransactionRequest>> createLenderTransactionRequest(@RequestBody List<TransactionRequest> transactionRequests)
  {
    ResponseDTO<List<TransactionRequest>> responseDTO;
    try {
      responseDTO = transactionService.createTransactionRequest(transactionRequests);
    } catch (Exception e) {
      responseDTO = new ResponseDTO<>();
      responseDTO.setSuccess(true);
    }

    return responseDTO;
  }

  @PostMapping("/approveTransactionRequest/{id}")
  public ResponseDTO<TransactionInProgress> approveTransactionRequest(@PathVariable String id)
  {
    ResponseDTO<TransactionInProgress> responseDTO;
    try {
      responseDTO = transactionService.approveTransactionRequest(id);
    } catch (Exception e) {
      responseDTO = new ResponseDTO<>();
      responseDTO.setMessage(e.getMessage());
      responseDTO.setSuccess(false);
    }
    return responseDTO;
  }
  @PostMapping("/paidTransaction/{id}")
  public ResponseDTO<TransactionComplete> paidTransaction(@PathVariable String id){
    ResponseDTO<TransactionComplete> responseDTO = new ResponseDTO<>();
    try{
      responseDTO.setResponse(transactionService.paidTransaction(id));
      responseDTO.setSuccess(true);
    }catch (Exception e){
      responseDTO.setSuccess(false);
      responseDTO.setMessage(e.getMessage());
    }
    return responseDTO;
  }



}
