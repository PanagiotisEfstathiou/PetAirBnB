package com.edu.petairbnb.controller;

import com.edu.petairbnb.model.Carer;
import com.edu.petairbnb.model.Expertise;
import com.edu.petairbnb.service.BaseService;
import com.edu.petairbnb.service.CarerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Carers")
public class CarerController extends AbstractController<Carer> {
    private final CarerService carerService;

    protected BaseService<Carer> getBaseService() {
        return carerService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("get")
    public List<Carer> getCarers(){
        return this.carerService.findAll();
    }



}
