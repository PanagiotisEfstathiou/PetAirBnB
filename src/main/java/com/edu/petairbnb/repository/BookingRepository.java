package com.edu.petairbnb.repository;

import com.edu.petairbnb.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    @Query("select o from Booking o join fetch o.customer where o.id = :id")
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false"))
    Booking bookingHistory(Long id);

}
