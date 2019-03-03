package com.sih.microfinancing.repository;

import java.util.List;

import com.sih.microfinancing.entity.TransactionRequest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRequestRepository extends CrudRepository<TransactionRequest,String> {

  @Query(value = "select * from transaction_request where lender_id=?1", nativeQuery = true)
  List<TransactionRequest> getPendingTransaction(String lenderId);


  @Query(value = "select * from transaction_request where borrower_id=?1", nativeQuery = true)
  List<TransactionRequest> getBorrowerPendingTransaction(String borrowerId);
}
