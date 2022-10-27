package com.edu.petairbnb.controller;

import com.edu.petairbnb.model.Animal;
import com.edu.petairbnb.service.AnimalService;
import com.edu.petairbnb.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Animals")
public class AnimalController extends AbstractController<Animal> {

    private final AnimalService animalService;
    @Override
    protected BaseService<Animal> getBaseService() {
        return null;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("get")
    public List<Animal> getAnimals(){return this.animalService.findAll();}

}
