package com.sih.microfinancing.repository;

import java.util.List;

import com.sih.microfinancing.entity.TransactionComplete;
import com.sih.microfinancing.entity.TransactionRequest;

import org.hibernate.engine.transaction.spi.TransactionObserver;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionCompleteRepository extends CrudRepository<TransactionComplete,String> {


  @Query(value = "select * from transaction_complete where lender_id=?1", nativeQuery = true)
  List<TransactionComplete> getCompletedTransaction(String lenderId);

  @Query(value = "select * from transaction_complete where borrower_id=?1", nativeQuery = true)
  List<TransactionComplete> getBorrowerCompletedTransaction(String borrowerId);
}
