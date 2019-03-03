package com.sih.microfinancing.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.entity.BorrowerListing;
import com.sih.microfinancing.entity.LenderListing;
import com.sih.microfinancing.entity.TransactionComplete;
import com.sih.microfinancing.entity.TransactionInProgress;
import com.sih.microfinancing.entity.TransactionRequest;
import com.sih.microfinancing.entity.User;
import com.sih.microfinancing.repository.BorrowerListingRepository;
import com.sih.microfinancing.repository.LenderListingRepository;
import com.sih.microfinancing.repository.TransactionCompleteRepository;
import com.sih.microfinancing.repository.TransactionInProgressRepository;
import com.sih.microfinancing.repository.TransactionRequestRepository;
import com.sih.microfinancing.repository.UserRepository;
import com.sih.microfinancing.services.TransactionService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  BorrowerListingRepository borrowerListingRepository;

  @Autowired
  LenderListingRepository lenderListingRepository;

  @Autowired
  TransactionRequestRepository transactionRequestRepository;

  @Autowired
  TransactionInProgressRepository transactionInProgressRepository;

  @Autowired
  TransactionCompleteRepository transactionCompleteRepository;

  @Autowired
  UserRepository userRepository;

  @Override
  public ResponseDTO<TransactionRequest> createTransactionRequest(TransactionRequest transactionRequest)
      throws Exception {
    ResponseDTO<TransactionRequest> responseDTO = new ResponseDTO<>();
    TransactionRequest transactionRequest1 = transactionRequestRepository.save(transactionRequest);
    responseDTO.setSuccess(true);
    responseDTO.setResponse(transactionRequest1);
    return responseDTO;
  }

  @Override
  public ResponseDTO<TransactionInProgress> approveLenderTransactionRequest(String id) throws Exception {
    TransactionRequest transactionRequest = transactionRequestRepository.findOne(id);
    transactionRequest.setLenderRateOfInterest(transactionRequest.getLenderRateOfInterest());
    transactionRequest.setDays(transactionRequest.getBorrowerListing().getDuration());
    TransactionRequest transactionRequest1 = transactionRequestRepository.save(transactionRequest);
    User userLender= userRepository.findOne(transactionRequest1.getLenderId().getId());
    userLender.setAgriCredit(userLender.getAgriCredit() - transactionRequest1.getBorrowerListing().getAmmountRequested());
    User userBorrower = userRepository.findOne(transactionRequest1.getBorrowerId().getId());
    userBorrower.setAgriCredit(userBorrower.getAgriCredit()+transactionRequest1.getBorrowerListing().getAmmountRequested());
    userRepository.save(userBorrower);
    transactionRequestRepository.delete(transactionRequest);
    TransactionInProgress transactionInProgress = new TransactionInProgress();
    BeanUtils.copyProperties(transactionRequest1,transactionInProgress);
    transactionInProgress.setStartTimestamp(new Date().getTime());
    transactionInProgress.setEndTimeStamp(new Date().getTime()+transactionRequest1.getDays()*86400000);


    transactionInProgressRepository.save(transactionInProgress);
    ResponseDTO<TransactionInProgress> responseDTO = new ResponseDTO<>();
    responseDTO.setSuccess(true);
    responseDTO.setResponse(transactionInProgress);
    return responseDTO;
  }






  @Override
  public TransactionComplete paidTransaction(String id) {
    TransactionComplete transactionComplete = new TransactionComplete();
    TransactionInProgress transactionInProgress = transactionInProgressRepository.findOne(id);
    BeanUtils.copyProperties(transactionInProgress,transactionComplete);
    TransactionComplete transactionComplete1 = transactionCompleteRepository.save(transactionComplete);
    transactionInProgressRepository.delete(transactionInProgress);
    return transactionComplete1;
  }

  @Override
  public ResponseDTO<Void> rejectLenderTransactionRequest(String id) {
    TransactionRequest transactionRequest = transactionRequestRepository.findOne(id);
    transactionRequestRepository.delete(transactionRequest);
    ResponseDTO<Void> responseDTO = new ResponseDTO<>();
    responseDTO.setSuccess(true);
    responseDTO.setResponse(null);
    return responseDTO;
  }

  @Override
  public ResponseDTO<List<TransactionRequest>> getPendingTransaction(String lenderId) throws Exception {
    ResponseDTO<List<TransactionRequest>> responseDTO = new ResponseDTO<>();
    responseDTO.setResponse(transactionRequestRepository.getPendingTransaction(lenderId));
    responseDTO.setSuccess(true);
    return responseDTO;
  }

  @Override
  public ResponseDTO<List<TransactionInProgress>> getTransactionInProgress(String lenderId) throws Exception {
    ResponseDTO<List<TransactionInProgress>> responseDTO = new ResponseDTO<>();
    responseDTO.setResponse(transactionInProgressRepository.getInProgressTransaction(lenderId));
    responseDTO.setSuccess(true);
    return responseDTO;
  }

  @Override
  public ResponseDTO<List<TransactionComplete>> getCompletedTransaction(String lenderId) throws Exception {
    ResponseDTO<List<TransactionComplete>> responseDTO = new ResponseDTO<>();
    responseDTO.setResponse(transactionCompleteRepository.getCompletedTransaction(lenderId));
    responseDTO.setSuccess(true);
    return responseDTO;
  }

  @Override
  public ResponseDTO<List<TransactionRequest>> getBorrowerPendingTransaction(String borrowerId) throws Exception{
    ResponseDTO<List<TransactionRequest>> responseDTO = new ResponseDTO<>();
    responseDTO.setResponse(transactionRequestRepository.getBorrowerPendingTransaction(borrowerId));
    responseDTO.setSuccess(true);
    return responseDTO;
  }


  @Override
  public ResponseDTO<List<TransactionInProgress>> getBorrowerTransactionInProgress(String borrowerId) throws Exception{
    ResponseDTO<List<TransactionInProgress>> responseDTO = new ResponseDTO<>();
    responseDTO.setResponse(transactionInProgressRepository.getBorrowerInProgressTransaction(borrowerId));
    responseDTO.setSuccess(true);
    return responseDTO;
  }

  @Override
  public ResponseDTO<List<TransactionComplete>> getBorrowerCompletedTransaction(String borrowerId) throws Exception{
    ResponseDTO<List<TransactionComplete>> responseDTO = new ResponseDTO<>();
    responseDTO.setResponse(transactionCompleteRepository.getBorrowerCompletedTransaction(borrowerId));
    responseDTO.setSuccess(true);
    return responseDTO;
  }


}
