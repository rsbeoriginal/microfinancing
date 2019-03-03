package com.sih.microfinancing.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sih.microfinancing.dto.BorrowerListingDTO;
import com.sih.microfinancing.dto.ResponseDTO;
import com.sih.microfinancing.entity.BorrowerListing;
import com.sih.microfinancing.entity.TransactionComplete;
import com.sih.microfinancing.entity.TransactionInProgress;
import com.sih.microfinancing.entity.User;
import com.sih.microfinancing.repository.BorrowerListingRepository;
import com.sih.microfinancing.repository.TransactionCompleteRepository;
import com.sih.microfinancing.repository.TransactionInProgressRepository;
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

    @Autowired
  TransactionCompleteRepository transactionCompleteRepository;

    @Autowired
  TransactionInProgressRepository transactionInProgressRepository;

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
      borrowerListingDTOS.add(borrowerListingDTO);
    }
    responseDTO.setSuccess(true);
    responseDTO.setResponse(borrowerListingDTOS);
    return  responseDTO;
  }

  @Override
  public List<BorrowerListing> getListingById(String borrowerId) {
      return borrowerListingRepository.getListingById(borrowerId);
  }

  @Override
  public BorrowerListing getListing(String id) {

    return borrowerListingRepository.getListing(id).get(0);
  }

  @Override
  public ResponseDTO<BorrowerListing> payLender(String transactionId, double ammount) {

      TransactionInProgress transactionInProgress = transactionInProgressRepository.findOne(transactionId);
      double ammountRequested = transactionInProgress.getBorrowerListing().getAmmountRequested();
      double ammountGiven = transactionInProgress.getBorrowerListing().getAmmountGiven();
      BorrowerListing borrowerListing;
      //0.02 is the platform fee
      User userBorrower = userRepository.findOne(transactionInProgress.getBorrowerId().getId());
      User userLender = userRepository.findOne(transactionInProgress.getLenderId().getId());
      userBorrower.setAgriCredit(userBorrower.getAgriCredit()-ammount);
      userLender.setAgriCredit(userLender.getAgriCredit()+ammount);
      System.out.println(ammount);
      System.out.println((int)Math.ceil((1+(transactionInProgress.getLenderRateOfInterest()/100)+0.02)*ammountRequested - ammountGiven));
      if(ammount==Math.ceil((1+(transactionInProgress.getLenderRateOfInterest()/100)+0.02)*ammountRequested - ammountGiven)) {
        // complete the transaction
        //check the duration, if the user is paying the ammount before 10 days, give him cashback
        borrowerListing = borrowerListingRepository.findOne(transactionInProgress.getBorrowerListing().getId());
        borrowerListing.setAmmountGiven(borrowerListing.getAmmountGiven()+ammount);
        //borrowerListingRepository.delete(borrowerListing);
        if(new Date().getTime() < transactionInProgress.getEndTimeStamp()) {
          userBorrower.setAgriCredit(userBorrower.getAgriCredit() + 0.01 * ammountRequested);
          transactionInProgress.getBorrowerId().setAgriCredit( transactionInProgress.getBorrowerId().getAgriCredit() + 0.01 * ammountRequested);
        }
        transactionInProgressRepository.delete(transactionInProgress);
        TransactionComplete transactionComplete = new TransactionComplete();
        BeanUtils.copyProperties(transactionInProgress,transactionComplete);
        transactionCompleteRepository.save(transactionComplete);
        //set the credit score
        long creditScoreNew = userBorrower.getCreditScore()+10*(transactionInProgress.getEndTimeStamp()-new Date().getTime())/(transactionInProgress.getEndTimeStamp()-transactionInProgress.getStartTimestamp());
        userBorrower.setCreditScore((int)creditScoreNew);

      }else{
        borrowerListing = borrowerListingRepository.findOne(transactionInProgress.getBorrowerListing().getId());
        borrowerListing.setAmmountGiven(borrowerListing.getAmmountGiven()+ammount);
        borrowerListingRepository.save(borrowerListing);
      }
      userRepository.save(userBorrower);
      userRepository.save(userLender);
      ResponseDTO<BorrowerListing> responseDTO = new ResponseDTO<>();
      responseDTO.setSuccess(true);
      responseDTO.setResponse(borrowerListing);
      //transactionInProgress.getBorrowerListing().getAmmountRequested()- = ammount ;
    return responseDTO;
  }


}
