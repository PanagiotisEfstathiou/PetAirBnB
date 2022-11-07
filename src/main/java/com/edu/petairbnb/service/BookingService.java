package com.edu.petairbnb.service;

import com.edu.petairbnb.model.Booking;
import org.springframework.stereotype.Service;

@Service
public interface BookingService extends BaseService<Booking> {

    Booking bookingHistory(Long id);
}
