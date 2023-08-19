package com.example.prog4.service;

import com.example.prog4.repository.management.PositionRepository;
import com.example.prog4.model.core.entity.management.Position;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionService {
    private PositionRepository repository;

    public List<Position> getAll(){
        return repository.findAll();
    }
    public Position saveOne(Position position){
        return repository.save(position);
    }
}
