package com.sih.microfinancing.services;

import java.util.List;

import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.entity.TransactionComplete;
import com.sih.microfinancing.entity.TransactionInProgress;
import com.sih.microfinancing.entity.TransactionRequest;

public interface TransactionService {

   ResponseDTO<TransactionRequest> createTransactionRequest(TransactionRequest transactionRequest) throws Exception;

   ResponseDTO<TransactionInProgress> approveLenderTransactionRequest(String id) throws Exception;

    TransactionComplete paidTransaction(String id);

  ResponseDTO<Void> rejectLenderTransactionRequest(String id);

  ResponseDTO<List<TransactionRequest>> getPendingTransaction(String lenderId) throws Exception;

  ResponseDTO<List<TransactionInProgress>> getTransactionInProgress(String lenderId) throws Exception;

  ResponseDTO<List<TransactionComplete>> getCompletedTransaction(String lenderId) throws Exception;

  ResponseDTO<List<TransactionRequest>> getBorrowerPendingTransaction(String borrowerId) throws Exception;

  ResponseDTO<List<TransactionInProgress>> getBorrowerTransactionInProgress(String borrowerId) throws Exception;

  ResponseDTO<List<TransactionComplete>> getBorrowerCompletedTransaction(String borrowerId) throws Exception;


}
