package com.evilcorp.evilfridge.controllers;

import com.evilcorp.evilfridge.models.PostIt;
import com.evilcorp.evilfridge.services.postItService.PostItService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/postits")
    public ResponseEntity createPostIt(PostIt postIt) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/api/postits")
    public ResponseEntity deletePostIt(@RequestParam ("postitid") Long postitId) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
}
