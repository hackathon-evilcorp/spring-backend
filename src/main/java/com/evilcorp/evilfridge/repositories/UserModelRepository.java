package com.evilcorp.evilfridge.repositories;

import com.evilcorp.evilfridge.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, Long> {
}
