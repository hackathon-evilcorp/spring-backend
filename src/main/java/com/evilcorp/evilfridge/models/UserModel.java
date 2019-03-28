package com.evilcorp.evilfridge.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "user_model")
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "user_name")
  private String name;

  @Column(name = "user_email")
  private String email;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "users_fridges",
      joinColumns = {@JoinColumn(name = "user_model_id")},
      inverseJoinColumns = {@JoinColumn(name = "fridge_id")})
  private ArrayList<Fridge> fridges;

  public UserModel() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ArrayList<Fridge> getFridges() {
    return fridges;
  }

  public void setFridges(ArrayList<Fridge> fridges) {
    this.fridges = fridges;
  }
}
