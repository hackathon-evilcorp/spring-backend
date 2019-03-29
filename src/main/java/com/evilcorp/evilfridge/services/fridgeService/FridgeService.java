package com.evilcorp.evilfridge.services.fridgeService;

import com.evilcorp.evilfridge.models.Fridge;

import java.util.List;

public interface FridgeService {
    public Fridge getFridgeById(Long fridgeId);
    public boolean saveFridge(Fridge fridge);
    public boolean deleteFridge(Long fridgeId);
}
