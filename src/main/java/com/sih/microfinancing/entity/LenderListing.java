package com.sih.microfinancing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class LenderListing {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name="uuid",strategy = "uuid2")
  private String id;
  private String createdBy;
  private double actualAmmount;
  private double ammountLeft;

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

  public double getActualAmmount() {
    return actualAmmount;
  }

  public void setActualAmmount(double actualAmmount) {
    this.actualAmmount = actualAmmount;
  }

  public double getAmmountLeft() {
    return ammountLeft;
  }

  public void setAmmountLeft(double ammountLeft) {
    this.ammountLeft = ammountLeft;
  }

  @Override
  public String toString() {
    return "LenderListing{" + "id='" + id + '\'' + ", createdBy='" + createdBy + '\'' + ", actualAmmount="
        + actualAmmount + ", ammountLeft=" + ammountLeft + '}';
  }
}
