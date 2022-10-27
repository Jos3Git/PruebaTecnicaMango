package com.mango.repositories;

import com.mango.model.Slogan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SloganRepository extends JpaRepository<Slogan, Long> {
}
