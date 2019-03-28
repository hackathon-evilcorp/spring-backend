package com.evilcorp.evilfridge.services.userModelService;

import com.evilcorp.evilfridge.models.UserModel;

public interface UserModelService {

  void saveUser (UserModel userModel);

  UserModel findByUserId(long id);
}
