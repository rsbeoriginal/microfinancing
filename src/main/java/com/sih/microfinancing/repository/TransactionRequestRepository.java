package com.sih.microfinancing.repository;

import com.sih.microfinancing.entity.TransactionRequest;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRequestRepository extends CrudRepository<TransactionRequest,String> {
}
