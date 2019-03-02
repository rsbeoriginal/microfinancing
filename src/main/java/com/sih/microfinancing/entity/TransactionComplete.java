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
  @ManyToOne
  @JoinColumn(name = "lender_listing_id")
  private LenderListing lenderListing;
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

  @Override
  public String toString() {
    return "TransactionInProgressRepository{" + "id='" + id + '\'' + ", lenderListing=" + lenderListing + ", borrowerListing="
        + borrowerListing + ", borrowerId='" + borrowerId + '\'' + ", lenderId='" + lenderId + '\'' + ", ammount="
        + ammount + '}';
  }
}
