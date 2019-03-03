package com.sih.microfinancing.repository;

import java.util.List;

import com.sih.microfinancing.entity.TransactionInProgress;
import com.sih.microfinancing.entity.TransactionRequest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionInProgressRepository extends CrudRepository<TransactionInProgress,String> {

  @Query(value = "select * from transaction_in_progress where lender_id=?1", nativeQuery = true)
  List<TransactionInProgress> getInProgressTransaction(String lenderId);

  @Query(value = "select * from transaction_in_progress where borrower_id=?1", nativeQuery = true)
  List<TransactionInProgress> getBorrowerInProgressTransaction(String borrowerId);
}
