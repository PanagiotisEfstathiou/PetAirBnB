package com.edu.petairbnb.repository;

import com.edu.petairbnb.model.Carer;
import com.edu.petairbnb.model.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface CarerRepository extends JpaRepository<Carer,Long> {

    @Query("select o from Carer o where o.expertise = :expertise")
    Carer findByExpertise(Expertise expertise);

//    @Query("select o.review from Carer o where o.id = :id")
//    String getReview(Long id);

//    SELECT  first_name from accounts,account_reviews
//    where
//       (select count(account_id) as accounts) and
//        account_id = accounts.id
//    group by account_id
//    order by account_id asc

//    @Query(value = "SELECT  first_name, carer_id, count(review) as review from carers,carer_reviews where (select count(carer_id) as carers) and carer_id = carers.id group by carer_id order by carer_id asc", nativeQuery = true)
//    Carer getPopular();
}
