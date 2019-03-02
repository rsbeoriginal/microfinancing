package com.sih.microfinancing.repository;

import com.sih.microfinancing.entity.TransactionInProgress;
import org.springframework.data.repository.CrudRepository;

public interface TransactionInProgressRepository extends CrudRepository<TransactionInProgress,String> {
}
