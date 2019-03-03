package com.sih.microfinancing.dto;

import com.sih.microfinancing.entity.User;

public class BorrowerListingDTO {

  private String id;
  private User createdBy;
  private double ammountRequested;
  private double ammountGiven;
  private double rateOfInterest;
  private int creditScore;
  private int duration;



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

  public double getAmmountGiven() {
    return ammountGiven;
  }

  public void setAmmountGiven(double ammountGiven) {
    this.ammountGiven = ammountGiven;
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

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }



  @Override
  public String toString() {
    return "BorrowerListingDTO{" + "id='" + id + '\'' + ", createdBy=" + createdBy + ", ammountRequested="
        + ammountRequested + ", ammountGiven=" + ammountGiven + ", rateOfInterest=" + rateOfInterest + ", creditScore="
        + creditScore + ", duration=" + duration + '}';
  }
}
