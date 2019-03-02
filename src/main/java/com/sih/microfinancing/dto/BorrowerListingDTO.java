package com.sih.microfinancing.dto;

import com.sih.microfinancing.entity.User;

public class BorrowerListingDTO {

  private String id;
  private User createdBy;
  private double ammountRequested;
  private double ammountRecieved;
  private double rateOfInterest;
  private int creditScore;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public User getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
  }


  public double getAmmountRequested() {
    return ammountRequested;
  }

  public void setAmmountRequested(double ammountRequested) {
    this.ammountRequested = ammountRequested;
  }

  public double getAmmountRecieved() {
    return ammountRecieved;
  }

  public void setAmmountRecieved(double ammountRecieved) {
    this.ammountRecieved = ammountRecieved;
  }

  public double getRateOfInterest() {
    return rateOfInterest;
  }

  public void setRateOfInterest(double rateOfInterest) {
    this.rateOfInterest = rateOfInterest;
  }

  public int getCreditScore() {
    return creditScore;
  }

  public void setCreditScore(int creditScore) {
    this.creditScore = creditScore;
  }

  @Override
  public String toString() {
    return "BorrowerListingDTO{" + "id='" + id + '\'' + ", createdBy=" + createdBy + ", ammountRequested='"
        + ammountRequested + '\'' + ", ammountRecieved='" + ammountRecieved + '\'' + ", rateOfInterest="
        + rateOfInterest + ", creditScore=" + creditScore + '}';
  }
}
