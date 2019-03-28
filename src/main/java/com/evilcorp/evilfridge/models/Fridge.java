package com.evilcorp.evilfridge.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "fridge")
public class Fridge {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "fridge_name")
  private String name;

  @OneToMany(mappedBy = "fridge", cascade = CascadeType.ALL)
  private ArrayList<PostIt> postIts;

  @ManyToMany(mappedBy = "fridges")
  private ArrayList<String> userList;

  private String admin;

  public Fridge() {
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

  public ArrayList<PostIt> getPostIts() {
    return postIts;
  }

  public void setPostIts(ArrayList<PostIt> postIts) {
    this.postIts = postIts;
  }

  public ArrayList<String> getUserList() {
    return userList;
  }

  public void setUserList(ArrayList<String> userList) {
    this.userList = userList;
  }

  public String getAdmin() {
    return admin;
  }

  public void setAdmin(String admin) {
    this.admin = admin;
  }
}
