package com.edu.petairbnb.service;

import com.edu.petairbnb.model.Carer;
import com.edu.petairbnb.model.Expertise;
import com.edu.petairbnb.repository.CarerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@AllArgsConstructor
public class CarerServiceImpl extends BaseServiceImpl<Carer> implements CarerService {

    private CarerRepository carerRepository;

    @Override
    public JpaRepository<Carer, Long> getRepository() {return carerRepository;}

    @Override
    public Carer findByExpertise(Expertise exp) {
        return carerRepository.findByExpertise(exp);
    }

//    @Override
//    public Carer getPopular() {
//        return carerRepository.getPopular();
//    }
//
//    @Override
//    public String getAllReviews(Long id){
//        return carerRepository.getReview(id).toString();
//    }
}
