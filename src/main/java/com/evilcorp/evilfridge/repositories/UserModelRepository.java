package com.evilcorp.evilfridge.repositories;

import com.evilcorp.evilfridge.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, Long> {

  Optional<UserModel> findByEmail(String email);

  boolean existsByEmail(String email);

  UserModel findById(long id);
}
