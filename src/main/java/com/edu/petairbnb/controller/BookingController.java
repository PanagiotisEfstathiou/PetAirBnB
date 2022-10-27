package com.edu.petairbnb.controller;

import com.edu.petairbnb.model.Account;
import com.edu.petairbnb.model.Booking;
import com.edu.petairbnb.service.BaseService;
import com.edu.petairbnb.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Bookings")
public class BookingController extends AbstractController<Booking> {

    private final BookingService bookingService;
    @Override
    protected BaseService<Booking> getBaseService() {
        return null;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("get")
    public List<Booking> getBookings(){
        return this.bookingService.findAll();
    }

}
