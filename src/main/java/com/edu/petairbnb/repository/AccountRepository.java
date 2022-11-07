package com.edu.petairbnb.repository;

import com.edu.petairbnb.model.Account;
import com.edu.petairbnb.model.Booking;
import com.edu.petairbnb.model.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import static org.hibernate.loader.Loader.SELECT;

@Repository
@Component
public interface AccountRepository extends JpaRepository<Account,Long> {

    @Query("select o from Account o where o.expertise = :expertise")
    Account findByExpertise(Expertise expertise);

}
