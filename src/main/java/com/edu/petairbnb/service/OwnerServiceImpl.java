package com.edu.petairbnb.service;

import com.edu.petairbnb.model.Owner;
import com.edu.petairbnb.repository.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@AllArgsConstructor
public class OwnerServiceImpl extends BaseServiceImpl<Owner> implements OwnerService {

    private OwnerRepository ownerRepository;
    @Override
    public JpaRepository<Owner, Long> getRepository() {return ownerRepository;}


}
