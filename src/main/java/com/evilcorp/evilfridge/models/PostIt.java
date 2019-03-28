package com.evilcorp.evilfridge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "postit")
public class PostIt {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String content;

  private String type;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fridge_id")
  @JsonIgnore
  private Fridge fridge;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_model_id")
  @JsonIgnore
  private UserModel creator;

  public PostIt() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public UserModel getCreator() {
    return creator;
  }

  public void setCreator(UserModel creator) {
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
