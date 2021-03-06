package com.evilcorp.evilfridge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_model")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "user_name")
  private String name;

  @Column(name = "user_email")
  private String email;

  @ManyToMany(mappedBy = "users", cascade = {CascadeType.ALL},
      fetch = FetchType.LAZY)
  @JsonIgnoreProperties("users")
  private List<Fridge> fridges = new ArrayList<>();

  @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnoreProperties("creator")
  private List<PostIt> postIts = new ArrayList<>();

  public UserModel() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public List<Fridge> getFridges() {
    return fridges;
  }

  public void setFridges(List<Fridge> fridges) {
    this.fridges = fridges;
  }

  public List<PostIt> getPostIts() {
    return postIts;
  }

  public void setPostIts(List<PostIt> postIts) {
    this.postIts = postIts;
  }
}
