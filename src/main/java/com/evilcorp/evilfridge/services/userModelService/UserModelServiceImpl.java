package com.evilcorp.evilfridge.services.userModelService;

import com.evilcorp.evilfridge.models.Fridge;
import com.evilcorp.evilfridge.models.UserModel;
import com.evilcorp.evilfridge.repositories.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserModelServiceImpl implements UserModelService{

  private UserModelRepository userModelRepository;

  @Autowired
  public UserModelServiceImpl(UserModelRepository userModelRepository) {
    this.userModelRepository = userModelRepository;
  }

  @Override
  public void saveUser(UserModel userModel) {
    userModelRepository.save(userModel);
  }

  @Override
  public UserModel findByUserId(long id) {
    return userModelRepository.findById(id);
  }
}
