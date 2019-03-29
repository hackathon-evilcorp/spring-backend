package com.evilcorp.evilfridge.controllers;

import com.evilcorp.evilfridge.models.UserModel;
import com.evilcorp.evilfridge.services.userModelService.UserModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserModelController {

  private UserModelServiceImpl userModelService;

  @Autowired
  public UserModelController(UserModelServiceImpl userModelService) {
    this.userModelService = userModelService;
  }

  @GetMapping("/api/user/fridges")
  public ResponseEntity getUserFridges(@RequestParam Long id) {
    if (id == null) {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity(userModelService.findUserById(id).getFridges(), HttpStatus.OK);
    }
  }

  @GetMapping("/api/user/postits")
  public ResponseEntity getUserPostIts (@RequestParam Long id) {
    if (id == null) {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity(userModelService.findUserById(id).getPostIts(), HttpStatus.OK);
    }
  }

  @GetMapping("/api/user")
  public ResponseEntity getUserById(@RequestParam Long id) {
    if (id == null) {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity(userModelService.findUserById(id), HttpStatus.OK);
    }
  }

  @PostMapping("/api/user")
  public ResponseEntity saveUser(@RequestBody UserModel userModel) {
    if (userModel == null) {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    } else {
      userModelService.saveUser(userModel);
      return new ResponseEntity(HttpStatus.OK);
    }
  }

  @DeleteMapping("/api/user")
  public ResponseEntity deleteUserById(@RequestParam Long id) {
    if (id == null) {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    } else {
      userModelService.deleteUserById(id);
      return new ResponseEntity(HttpStatus.OK);
    }
  }
}
