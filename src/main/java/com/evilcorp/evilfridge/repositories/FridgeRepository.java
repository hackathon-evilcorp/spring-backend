package com.evilcorp.evilfridge.repositories;

import com.evilcorp.evilfridge.models.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Long> {
    @Query(value = "SELECT f FROM fridge f" +
            " INNER JOIN users_fridges ON users_fridges.fridge_id = f.id" +
            " WHERE user_model_id = id",
    nativeQuery = true
    )
    public List<Fridge> findByUserId(@Param("id") Long id);
}
