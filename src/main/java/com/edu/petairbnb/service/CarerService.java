package com.edu.petairbnb.service;

import com.edu.petairbnb.model.Carer;
import com.edu.petairbnb.model.Expertise;
import org.springframework.stereotype.Service;

@Service
public interface CarerService extends BaseService<Carer>{
    Carer findByExpertise(Expertise exp);

//    Carer getPopular();
//
//    String getAllReviews(Long id);
}