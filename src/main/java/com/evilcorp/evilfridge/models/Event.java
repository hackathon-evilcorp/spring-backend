package com.evilcorp.evilfridge.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Basic
  @Temporal(TemporalType.TIMESTAMP)
  private java.util.Date utilTimestamp;

  public Event() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getUtilTimestamp() {
    return utilTimestamp;
  }

  public void setUtilTimestamp(Date utilTimestamp) {
    this.utilTimestamp = utilTimestamp;
  }
}
