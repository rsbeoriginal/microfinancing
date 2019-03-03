package com.sih.microfinancing.services;

import java.util.List;

import com.sih.microfinancing.dto.BorrowerListingDTO;
import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.entity.BorrowerListing;

public interface BorrowerService {
  BorrowerListing addListing(BorrowerListing borrowerListing);

  ResponseDTO<List<BorrowerListingDTO>> getListing();

  List<BorrowerListing> getListingById(String borrowerId);

  BorrowerListing getListing(String id);

  ResponseDTO<BorrowerListing> payLender(String transactionId, double ammount);
}
