package com.edu.petairbnb.repository;

import com.edu.petairbnb.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AnimalRepository extends JpaRepository<Animal,Long> {
}
