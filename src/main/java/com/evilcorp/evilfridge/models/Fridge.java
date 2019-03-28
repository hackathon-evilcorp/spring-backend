package com.evilcorp.evilfridge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fridge")
public class Fridge {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "fridge_name")
  private String name;

  @OneToMany(mappedBy = "fridge", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<PostIt> postIts = new ArrayList<>();

  @ManyToMany(cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  @JoinTable(name = "users_fridges",
      joinColumns = @JoinColumn(name = "fridge_id"),
      inverseJoinColumns = @JoinColumn(name = "user_model_id"))
  @JsonIgnoreProperties("fridges")
  private List<UserModel> users = new ArrayList<>();

  private String admin;

  public Fridge() {
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

  public List<PostIt> getPostIts() {
    return postIts;
  }

  public void setPostIts(List<PostIt> postIts) {
    this.postIts = postIts;
  }

  public List<UserModel> getUsers() {
    return users;
  }

  public void setUsers(List<UserModel> users) {
    this.users = users;
  }

  public String getAdmin() {
    return admin;
  }

  public void setAdmin(String admin) {
    this.admin = admin;
  }
}
