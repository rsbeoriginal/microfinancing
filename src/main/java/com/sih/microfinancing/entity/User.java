package com.sih.microfinancing.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import static com.sih.microfinancing.entity.User.TABLE_NAME;

@Entity(name = TABLE_NAME)
public class User {

    public static final String TABLE_NAME = "user_";

    @Id
    String id;

    String userType;
    String name;
    String kycNumber;
    int creditScore;
    double agriCredit;
    String phoneNumber;

    public static String getTableName() {
        return TABLE_NAME;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKycNumber() {
        return kycNumber;
    }

    public void setKycNumber(String kycNumber) {
        this.kycNumber = kycNumber;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public double getAgriCredit() {
        return agriCredit;
    }

    public void setAgriCredit(double agriCredit) {
        this.agriCredit = agriCredit;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
