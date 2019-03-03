package com.sih.microfinancing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class LenderListing {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name="uuid",strategy = "uuid2")
  private String id;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User createdBy;
  private long startTimestamp;
  private int days;
  private long endTimeStamp;

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

  @Override
  public String toString() {
    return "LenderListing{" + "id='" + id + '\'' + ", createdBy=" + createdBy + ", startTimestamp=" + startTimestamp
        + ", days=" + days + ", endTimeStamp=" + endTimeStamp + '}';
  }
}
