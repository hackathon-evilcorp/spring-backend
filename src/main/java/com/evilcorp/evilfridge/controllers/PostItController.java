package com.evilcorp.evilfridge.controllers;

import com.evilcorp.evilfridge.services.postItService.PostItService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostItController {
    PostItService postItService;

    @Autowired
    public PostItController(PostItService postItService) {
        this.postItService = postItService;
    }

    @GetMapping("/api/postits")
    public ResponseEntity getPostItsOfFridge(
            @RequestParam(value = "fridgeId", required = false) Long fridgeId,
            @RequestParam(value = "userId", required = false) Long userId) {
        if(fridgeId == null && userId == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
