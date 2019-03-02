package com.sih.microfinancing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class BorrowerListing {


  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name="uuid",strategy = "uuid2")
  private String id;
  private String createdBy;
  private String ammountRequested;
  private String ammountRecieved;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getAmmountRequested() {
    return ammountRequested;
  }

  public void setAmmountRequested(String ammountRequested) {
    this.ammountRequested = ammountRequested;
  }

  public String getAmmountRecieved() {
    return ammountRecieved;
  }

  public void setAmmountRecieved(String ammountRecieved) {
    this.ammountRecieved = ammountRecieved;
  }

  @Override
  public String toString() {
    return "BorrowerListing{" + "id='" + id + '\'' + ", createdBy='" + createdBy + '\'' + ", ammountRequested='"
        + ammountRequested + '\'' + ", ammountRecieved='" + ammountRecieved + '\'' + '}';
  }
}
