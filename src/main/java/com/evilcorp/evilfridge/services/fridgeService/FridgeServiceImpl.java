package com.evilcorp.evilfridge.services.fridgeService;

import com.evilcorp.evilfridge.repositories.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FridgeServiceImpl implements FridgeService{

  private FridgeRepository fridgeRepository;

  @Autowired
  public FridgeServiceImpl(FridgeRepository fridgeRepository) {
    this.fridgeRepository = fridgeRepository;
  }
}
