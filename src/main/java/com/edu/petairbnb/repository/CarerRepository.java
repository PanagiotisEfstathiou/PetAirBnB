package com.edu.petairbnb.repository;

import com.edu.petairbnb.model.Carer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarerRepository extends JpaRepository<Carer, Long>{
}
