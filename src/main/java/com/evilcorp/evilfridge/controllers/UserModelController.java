package com.evilcorp.evilfridge.controllers;

import com.evilcorp.evilfridge.services.userModelService.UserModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
      return new ResponseEntity(userModelService.findByUserId(id).getFridges(), HttpStatus.OK);
    }
  }
}
