package com.example.prog4.repository.management;

import com.example.prog4.model.core.entity.management.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, String> {
    Optional<Position> findPositionByNameEquals(String name);
}
