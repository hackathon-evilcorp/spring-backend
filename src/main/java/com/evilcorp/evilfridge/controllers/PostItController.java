package com.evilcorp.evilfridge.controllers;

import com.evilcorp.evilfridge.models.PostIt;
import com.evilcorp.evilfridge.services.postItService.PostItService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PostItController {
    private PostItService postItService;

    @Autowired
    public PostItController(PostItService postItService) {
        this.postItService = postItService;
    }

    @GetMapping("/api/postits")
    public ResponseEntity getPostIts(
            @RequestParam(value = "fridgeId", required = false) Long fridgeId,
            @RequestParam(value = "userId", required = false) Long userId) {
        List<PostIt> answer;
        if ((fridgeId == null || fridgeId == 0)
                && (userId == null || userId == 0)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else if (fridgeId == null || fridgeId == 0) {
            answer = postItService.getPostItsOfUser(userId);
        } else if (userId == null || userId == 0) {
            answer = postItService.getPostItsOfFridge(fridgeId);
        } else {
            answer = postItService.getPostItsOfUserAndFridge(userId, fridgeId);
        }
        return new ResponseEntity(answer, HttpStatus.OK);
    }

    @PostMapping("/api/postits")
    public ResponseEntity createPostIt(@RequestBody PostIt postIt) {
        return new ResponseEntity(postItService.savePostIt(postIt) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/api/postits")
    public ResponseEntity deletePostIt(@RequestParam("postitid") Long postitId) {
        return new ResponseEntity(postItService.deletePostIt(postitId) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
