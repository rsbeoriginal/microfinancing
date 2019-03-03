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
import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.entity.TransactionComplete;
import com.sih.microfinancing.entity.TransactionInProgress;
import com.sih.microfinancing.entity.TransactionRequest;
import com.sih.microfinancing.repository.TransactionRequestRepository;
import com.sih.microfinancing.services.TransactionService;

@CrossOrigin
@RestController
@RequestMapping(ApiConstants.TRANSACTION)
public class TransactionController {

  @Autowired
  TransactionService transactionService;

  @Autowired
  TransactionRequestRepository transactionRequestRepository;

  @PostMapping("/createLenderRequest")
  public ResponseDTO<TransactionRequest> createLenderTransactionRequest(@RequestBody TransactionRequest transactionRequests)
  {
    ResponseDTO<TransactionRequest> responseDTO= new ResponseDTO<>();
    try {
      responseDTO = transactionService.createTransactionRequest(transactionRequests);
    } catch (Exception e) {
      responseDTO.setSuccess(false);
      responseDTO.setMessage(e.getMessage());
    }

    return responseDTO;
  }

  @PostMapping("/approveLenderTransactionRequest/{id}")
  public ResponseDTO<TransactionInProgress> approveLenderTransactionRequest(@PathVariable String id)
  {
    ResponseDTO<TransactionInProgress> responseDTO;
    try {
      responseDTO = transactionService.approveLenderTransactionRequest(id);
    } catch (Exception e) {
      responseDTO = new ResponseDTO<>();
      responseDTO.setMessage(e.getMessage());
      responseDTO.setSuccess(false);
    }
    return responseDTO;
  }

  @PostMapping("/rejectLenderTransactionRequest/{id}")
  public ResponseDTO<Void> rejectLenderTransactionRequest(@PathVariable String id)
  {
    ResponseDTO<Void> responseDTO;
    try {
      responseDTO = transactionService.rejectLenderTransactionRequest(id);
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


  @GetMapping("/getPendingTransaction/{lenderId}")
  public ResponseDTO<List<TransactionRequest>> getPendingTransaction(@PathVariable String lenderId){
    ResponseDTO<List<TransactionRequest>> responseDTO = new ResponseDTO<>();
    try{
      responseDTO = transactionService.getPendingTransaction(lenderId);
    }catch (Exception e){
      responseDTO.setSuccess(false);
      responseDTO.setMessage(e.getMessage());
    }
    return responseDTO;
  }

  @GetMapping("/getInProgressTransaction/{lenderId}")
  public ResponseDTO<List<TransactionInProgress>> getInProgressTransaction(@PathVariable String lenderId){
    ResponseDTO<List<TransactionInProgress>> responseDTO = new ResponseDTO<>();
    try{
      responseDTO = transactionService.getTransactionInProgress(lenderId);
    }catch (Exception e){
      responseDTO.setSuccess(false);
      responseDTO.setMessage(e.getMessage());
    }
    return responseDTO;
  }


  @GetMapping("/getCompletedTransaction/{lenderId}")
  public ResponseDTO<List<TransactionComplete>> getCompletedTransaction(@PathVariable String lenderId){
    ResponseDTO<List<TransactionComplete>> responseDTO = new ResponseDTO<>();
    try{
      responseDTO = transactionService.getCompletedTransaction(lenderId);
    }catch (Exception e){
      responseDTO.setSuccess(false);
      responseDTO.setMessage(e.getMessage());
    }
    return responseDTO;
  }



  @GetMapping("/getBorrowerPendingTransaction/{borrowerId}")
  public ResponseDTO<List<TransactionRequest>> getBorrowerPendingTransaction(@PathVariable String borrowerId){
    ResponseDTO<List<TransactionRequest>> responseDTO = new ResponseDTO<>();
    try{
      responseDTO = transactionService.getBorrowerPendingTransaction(borrowerId);
    }catch (Exception e){
      responseDTO.setSuccess(false);
      responseDTO.setMessage(e.getMessage());
    }
    return responseDTO;
  }

  @GetMapping("/getBorrowerInProgressTransaction/{borrowerId}")
  public ResponseDTO<List<TransactionInProgress>> getBorrowerInProgressTransaction(@PathVariable String borrowerId){
    ResponseDTO<List<TransactionInProgress>> responseDTO = new ResponseDTO<>();
    try{
      responseDTO = transactionService.getBorrowerTransactionInProgress(borrowerId);
    }catch (Exception e){
      responseDTO.setSuccess(false);
      responseDTO.setMessage(e.getMessage());
    }
    return responseDTO;
  }


  @GetMapping("/getBorrowerCompletedTransaction/{borrowerId}")
  public ResponseDTO<List<TransactionComplete>> getBorrowerCompletedTransaction(@PathVariable String borrowerId){
    ResponseDTO<List<TransactionComplete>> responseDTO = new ResponseDTO<>();
    try{
      responseDTO = transactionService.getCompletedTransaction(borrowerId);
    }catch (Exception e){
      responseDTO.setSuccess(false);
      responseDTO.setMessage(e.getMessage());
    }
    return responseDTO;
  }


}
