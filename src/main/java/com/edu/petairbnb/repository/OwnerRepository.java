package com.edu.petairbnb.repository;

import com.edu.petairbnb.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
