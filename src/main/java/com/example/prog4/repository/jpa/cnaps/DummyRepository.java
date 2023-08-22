package com.example.prog4.repository.jpa.cnaps;

import com.example.prog4.model.core.entity.cnaps.Dummy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyRepository extends JpaRepository<Dummy, String> {
}
