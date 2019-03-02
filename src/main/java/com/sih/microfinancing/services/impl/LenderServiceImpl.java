package com.sih.microfinancing.services.impl;

import com.sih.microfinancing.entity.LenderListing;
import com.sih.microfinancing.repository.LenderListingRepository;
import com.sih.microfinancing.services.LenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class LenderServiceImpl implements LenderService {

    @Autowired
    LenderListingRepository lenderListingRepository;

    @Override
    public LenderListing addListing(LenderListing lenderListing) {
        return lenderListingRepository.save(lenderListing);
    }
}
