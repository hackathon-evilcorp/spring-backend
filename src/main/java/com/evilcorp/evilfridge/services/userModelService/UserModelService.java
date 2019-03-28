package com.evilcorp.evilfridge.services.userModelService;

import com.evilcorp.evilfridge.models.UserModel;

public interface UserModelService {

  void saveUser(UserModel userModel);

  UserModel findUserById(long id);

  void deleteUserById(Long id);
}
