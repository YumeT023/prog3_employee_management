package com.example.prog4.service.cnaps;

import com.example.prog4.model.core.entity.cnaps.Dummy;
import com.example.prog4.repository.cnaps.DummyRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DummyService {
  private final DummyRepository repository;

  public List<Dummy> findAll() {
    return repository.findAll();
  }
}
