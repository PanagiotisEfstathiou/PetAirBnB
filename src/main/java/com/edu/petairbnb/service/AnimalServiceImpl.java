package com.edu.petairbnb.service;

import com.edu.petairbnb.model.Animal;
import com.edu.petairbnb.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@AllArgsConstructor
public class AnimalServiceImpl extends BaseServiceImpl<Animal> implements AnimalService {

    private AnimalRepository animalRepository;
    @Override
    public JpaRepository<Animal, Long> getRepository() {
        return animalRepository;
    }
}
