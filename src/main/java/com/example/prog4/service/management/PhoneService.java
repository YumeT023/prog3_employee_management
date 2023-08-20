package com.example.prog4.service.management;

import com.example.prog4.repository.management.PhoneRepository;
import com.example.prog4.model.core.entity.management.Phone;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PhoneService {
    private PhoneRepository repository;

    public List<Phone> getAll(){
        return repository.findAll();
    }

    public Phone saveOne(Phone position){
        return repository.save(position);
    }
}
