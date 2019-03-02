package com.sih.microfinancing.services;

import java.util.List;

import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.entity.TransactionComplete;
import com.sih.microfinancing.entity.TransactionInProgress;
import com.sih.microfinancing.entity.TransactionRequest;

public interface TransactionService {

   ResponseDTO<List<TransactionRequest>> createTransactionRequest(List<TransactionRequest> transactionRequests) throws Exception;

   ResponseDTO<TransactionInProgress> approveTransactionRequest(String id) throws Exception;

    TransactionComplete paidTransaction(String id);
}
