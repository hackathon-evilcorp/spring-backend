package com.evilcorp.evilfridge.controllers;

import com.evilcorp.evilfridge.models.Fridge;
import com.evilcorp.evilfridge.services.fridgeService.FridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FridgeController {
    private FridgeService fridgeService;

    @Autowired
    public FridgeController (FridgeService fridgeService) {
        this.fridgeService = fridgeService;
    }

    @GetMapping("/api/fridges")
    public ResponseEntity getFridge(@RequestParam Long id) {
        if(id == null || id == 0) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(fridgeService.getFridgeById(id), HttpStatus.OK);
    }

    @PostMapping("/api/fridges")
    public ResponseEntity createFridge(Fridge fridge) {
        return new ResponseEntity(fridgeService.saveFridge(fridge)? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/api/fridges/{fridgeId}")
    public ResponseEntity deleteFridge(@PathVariable ("fridgeId") Long fridgeId) {
        return new ResponseEntity(fridgeService.deleteFridge(fridgeId)? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
