package com.sih.microfinancing.services.impl;

import com.sih.microfinancing.entity.BorrowerListing;
import com.sih.microfinancing.repository.BorrowerListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class BorrowerService {
    @Autowired
    BorrowerListingRepository borrowerListingRepository;
    public BorrowerListing addListing(BorrowerListing borrowerListing) {
        return borrowerListingRepository.save(borrowerListing);
    }
}
