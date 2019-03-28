package com.evilcorp.evilfridge.repositories;

import com.evilcorp.evilfridge.models.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Long> {
    String findByUserId = "SELECT * FROM fridge" +
            " INNER JOIN users_fridges ON users_fridges.fridge_id = fridge.id" +
            " WHERE user_model_id = (:userId)";
    @Query(value = findByUserId, nativeQuery = true)
    public List<Fridge> findByUserId(@Param("userId")Long userId);
}
