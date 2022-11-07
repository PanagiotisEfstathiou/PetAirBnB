package com.edu.petairbnb.service;

import com.edu.petairbnb.model.Booking;
import com.edu.petairbnb.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingServiceImpl extends BaseServiceImpl<Booking> implements BookingService {

    private BookingRepository bookingRepository;

    @Override
    public JpaRepository<Booking, Long> getRepository() {
        return bookingRepository;
    }

    @Override
    public Booking bookingHistory(Long id) {
        Booking booking = bookingRepository.bookingHistory(id);
        return booking;
    }
}
