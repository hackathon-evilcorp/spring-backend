package com.evilcorp.evilfridge.models;

import javax.persistence.*;

@Entity
public class PostIt {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String creator;

  private String content;

  private String type;

  @ManyToOne
  @JoinColumn
  private Fridge fridge;

  public PostIt() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Fridge getFridge() {
    return fridge;
  }

  public void setFridge(Fridge fridge) {
    this.fridge = fridge;
  }
}
