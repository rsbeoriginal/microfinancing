package com.sih.microfinancing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class TransactionInProgress {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name="uuid",strategy = "uuid2")
  private String id;
  @ManyToOne
  @JoinColumn(name = "lender_listing_id")
  private LenderListing lenderListing;
  @ManyToOne
  @JoinColumn(name = "borrower_listing_id")
  private BorrowerListing borrowerListing;
  private String borrowerId;
  private String lenderId;
  private double ammount;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LenderListing getLenderListing() {
    return lenderListing;
  }

  public void setLenderListing(LenderListing lenderListing) {
    this.lenderListing = lenderListing;
  }

  public String getBorrowerId() {
    return borrowerId;
  }

  public void setBorrowerId(String borrowerId) {
    this.borrowerId = borrowerId;
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

  public String getLenderId() {
    return lenderId;
  }

  public void setLenderId(String lenderId) {
    this.lenderId = lenderId;
  }

  @Override
  public String toString() {
    return "TransactionInProgress{" + "id='" + id + '\'' + ", lenderListing=" + lenderListing + ", borrowerListing="
        + borrowerListing + ", borrowerId='" + borrowerId + '\'' + ", lenderId='" + lenderId + '\'' + ", ammount="
        + ammount + '}';
  }
}
