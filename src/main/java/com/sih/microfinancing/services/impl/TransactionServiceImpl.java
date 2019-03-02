package com.sih.microfinancing.services.impl;

import com.sih.microfinancing.services.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class TransactionServiceImpl implements TransactionService {
}
