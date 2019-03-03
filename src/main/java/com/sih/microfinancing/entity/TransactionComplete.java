package com.sih.microfinancing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class TransactionComplete {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name="uuid",strategy = "uuid2")
  private String id;
  private long startTimestamp;
  private int days;
  private long endTimeStamp;
  private double lenderRateOfInterest;
  @ManyToOne
  @JoinColumn(name = "borrower_listing_id")
  private BorrowerListing borrowerListing;
  @ManyToOne
  @JoinColumn(name = "borrower_id")
  private User borrowerId;
  @ManyToOne
  @JoinColumn(name = "lender_id")
  private User lenderId;
  private double ammount;
  private String requestType;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }



  public BorrowerListing getBorrowerListing() {
    return borrowerListing;
  }

  public void setBorrowerListing(BorrowerListing borrowerListing) {
    this.borrowerListing = borrowerListing;
  }

  public double getAmmount() {
    return ammount;
  }

  public void setAmmount(double ammount) {
    this.ammount = ammount;
  }

  public User getBorrowerId() {
    return borrowerId;
  }

  public void setBorrowerId(User borrowerId) {
    this.borrowerId = borrowerId;
  }

  public User getLenderId() {
    return lenderId;
  }

  public void setLenderId(User lenderId) {
    this.lenderId = lenderId;
  }

  public String getRequestType() {
    return requestType;
  }

  public void setRequestType(String requestType) {
    this.requestType = requestType;
  }

  public long getStartTimestamp() {
    return startTimestamp;
  }

  public void setStartTimestamp(long startTimestamp) {
    this.startTimestamp = startTimestamp;
  }

  public int getDays() {
    return days;
  }

  public void setDays(int days) {
    this.days = days;
  }

  public long getEndTimeStamp() {
    return endTimeStamp;
  }

  public void setEndTimeStamp(long endTimeStamp) {
    this.endTimeStamp = endTimeStamp;
  }

  public double getLenderRateOfInterest() {
    return lenderRateOfInterest;
  }

  public void setLenderRateOfInterest(double lenderRateOfInterest) {
    this.lenderRateOfInterest = lenderRateOfInterest;
  }

  @Override
  public String toString() {
    return "TransactionRequest{" + "id='" + id + '\'' + ", startTimestamp=" + startTimestamp + ", days=" + days
        + ", endTimeStamp=" + endTimeStamp + ", lenderRateOfInterest=" + lenderRateOfInterest + ", borrowerListing="
        + borrowerListing + ", borrowerId=" + borrowerId + ", lenderId=" + lenderId + ", ammount=" + ammount
        + ", requestType='" + requestType + '\'' + '}';
  }
}
