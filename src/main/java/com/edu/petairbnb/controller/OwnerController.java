package com.edu.petairbnb.controller;

import com.edu.petairbnb.model.Owner;
import com.edu.petairbnb.service.OwnerService;
import com.edu.petairbnb.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Owners")
public class OwnerController extends AbstractController<Owner> {

    private final OwnerService ownerService;


    protected BaseService<Owner> getBaseService() {
        return ownerService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("get")
    public List<Owner> getAccounts(){
        return this.ownerService.findAll();
    }


}
