package com.sih.microfinancing.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.entity.TransactionComplete;
import com.sih.microfinancing.entity.TransactionInProgress;
import com.sih.microfinancing.entity.TransactionRequest;
import com.sih.microfinancing.repository.TransactionCompleteRepository;
import com.sih.microfinancing.repository.TransactionInProgressRepository;
import com.sih.microfinancing.repository.TransactionRequestRepository;
import com.sih.microfinancing.services.TransactionService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  TransactionRequestRepository transactionRequestRepository;

  @Autowired
  TransactionInProgressRepository transactionInProgressRepository;

  @Autowired
  TransactionCompleteRepository transactionCompleteRepository;

  @Override
  public ResponseDTO<List<TransactionRequest>> createTransactionRequest(List<TransactionRequest> transactionRequests)
      throws Exception {
    ResponseDTO<List<TransactionRequest>> responseDTO = new ResponseDTO<>();
    List<TransactionRequest> transactionRequests1 = new ArrayList<>();
    for(TransactionRequest transactionRequest: transactionRequests)
    {
      transactionRequests1.add(transactionRequestRepository.save(transactionRequest));
    }
    responseDTO.setSuccess(true);
    responseDTO.setResponse(transactionRequests1);
    return responseDTO;
  }

  @Override
  public ResponseDTO<TransactionInProgress> approveTransactionRequest(String id) throws Exception {
    TransactionRequest transactionRequest = transactionRequestRepository.findOne(id);
    TransactionInProgress transactionInProgress = new TransactionInProgress();
    BeanUtils.copyProperties(transactionRequest,transactionInProgress);
    transactionInProgress = transactionInProgressRepository.save(transactionInProgress);
    transactionRequestRepository.delete(id);
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
}
