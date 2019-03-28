package com.evilcorp.evilfridge.repositories;

import com.evilcorp.evilfridge.models.PostIt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostItRepository extends JpaRepository<PostIt, Long> {
}
