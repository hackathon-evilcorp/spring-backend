package com.evilcorp.evilfridge.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Event {

  private long id;
  private UserModel userModel;

  @Basic
  @Temporal(TemporalType.TIMESTAMP)
  private java.util.Date utilTimestamp;

  private Fridge fridge;

  public Event() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public UserModel getUserModel() {
    return userModel;
  }

  public void setUserModel(UserModel userModel) {
    this.userModel = userModel;
  }

  public Date getUtilTimestamp() {
    return utilTimestamp;
  }

  public void setUtilTimestamp(Date utilTimestamp) {
    this.utilTimestamp = utilTimestamp;
  }

  public Fridge getFridge() {
    return fridge;
  }

  public void setFridge(Fridge fridge) {
    this.fridge = fridge;
  }
}
