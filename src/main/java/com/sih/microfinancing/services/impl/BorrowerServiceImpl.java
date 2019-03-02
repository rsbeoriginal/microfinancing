package com.sih.microfinancing.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.sih.microfinancing.dto.BorrowerListingDTO;
import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.entity.BorrowerListing;
import com.sih.microfinancing.entity.User;
import com.sih.microfinancing.repository.BorrowerListingRepository;
import com.sih.microfinancing.repository.UserRepository;
import com.sih.microfinancing.services.BorrowerService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class BorrowerServiceImpl implements BorrowerService {
    @Autowired
    BorrowerListingRepository borrowerListingRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public BorrowerListing addListing(BorrowerListing borrowerListing) {
        return borrowerListingRepository.save(borrowerListing);
    }

  @Override
  public ResponseDTO<List<BorrowerListingDTO>> getListing() {
//    List<BorrowerListing> borrowerListings = borrowerListingRepository.getAll();
    List<BorrowerListing> borrowerListings = borrowerListingRepository.selectAll();
    ResponseDTO<List<BorrowerListingDTO>> responseDTO = new ResponseDTO<>();
    List<BorrowerListingDTO> borrowerListingDTOS = new ArrayList<>();
    for(int i=0;i<borrowerListings.size();i++)
    {
      BorrowerListingDTO borrowerListingDTO = new BorrowerListingDTO();
      BeanUtils.copyProperties(borrowerListings.get(i),borrowerListingDTO);
      User user = new User();
      BeanUtils.copyProperties(borrowerListings.get(i).getCreatedBy(),user);
      borrowerListingDTO.setCreatedBy(user);
      borrowerListingDTO.setCreditScore(user.getCreditScore());
      borrowerListingDTO.setRateOfInterest(getRateOfInterest(user.getCreditScore()));
      borrowerListingDTOS.add(borrowerListingDTO);
    }
    responseDTO.setSuccess(true);
    responseDTO.setResponse(borrowerListingDTOS);
    return  responseDTO;
  }

  private double getRateOfInterest(int creditScore) {
      return (100-creditScore)/(double)10;
  }


}
