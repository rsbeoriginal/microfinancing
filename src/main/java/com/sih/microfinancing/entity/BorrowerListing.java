package com.sih.microfinancing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class BorrowerListing {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name="uuid",strategy = "uuid2")
  private String id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User createdBy;
  private double ammountRequested;
  private double ammountGiven;
  private double rateOfInterest;
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

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  @Override
  public String toString() {
    return "BorrowerListing{" + "id='" + id + '\'' + ", createdBy=" + createdBy + ", ammountRequested="
        + ammountRequested + ", ammountGiven=" + ammountGiven + ", rateOfInterest=" + rateOfInterest + ", duration="
        + duration + '}';
  }
}
