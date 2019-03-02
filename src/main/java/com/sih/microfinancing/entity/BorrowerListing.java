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
  private double ammountRecieved;

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

  @Override
  public String toString() {
    return "BorrowerListing{" + "id='" + id + '\'' + ", createdBy='" + createdBy + '\'' + ", ammountRequested='"
        + ammountRequested + '\'' + ", ammountRecieved='" + ammountRecieved + '\'' + '}';
  }
}
