package com.evilcorp.evilfridge.repositories;

import com.evilcorp.evilfridge.models.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Long> {
    public List<Fridge> findByUsersContain_Id(Long id);
}
