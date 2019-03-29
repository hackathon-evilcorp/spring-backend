package com.evilcorp.evilfridge.services.fridgeService;

import com.evilcorp.evilfridge.models.Fridge;
import com.evilcorp.evilfridge.repositories.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FridgeServiceImpl implements FridgeService{

  private FridgeRepository fridgeRepository;

  @Autowired
  public FridgeServiceImpl(FridgeRepository fridgeRepository) {
    this.fridgeRepository = fridgeRepository;
  }

  @Override
  public Fridge getFridgeById(Long fridgeId) {
    return fridgeRepository.findById(fridgeId).orElse(null);
  }

  @Override
  public boolean saveFridge(Fridge fridge) {
    if(fridgeRepository.findById(fridge.getId()).isPresent()) {
      return false;
    }
    fridgeRepository.save(fridge);
    return true;
  }

  @Override
  public boolean deleteFridge(Long fridgeId) {
    if(fridgeRepository.findById(fridgeId).isPresent()) {
      fridgeRepository.delete(fridgeRepository.findById(fridgeId).get());
      return true;
    }
    return false;
  }
}
