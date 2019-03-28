package com.evilcorp.evilfridge.repositories;

import com.evilcorp.evilfridge.models.PostIt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostItRepository extends JpaRepository<PostIt, Long> {
    public List<PostIt> findByCreator_Id(Long userId);
    public List<PostIt> findByFridgeId(Long fridgeId);
    public List<PostIt> findByCreator_IdAndFridgeId(Long userId, Long fridgeId);
}
