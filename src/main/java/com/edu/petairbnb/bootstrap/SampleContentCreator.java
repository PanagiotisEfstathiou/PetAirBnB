package com.edu.petairbnb.bootstrap;

import com.edu.petairbnb.base.BaseComponent;
import com.edu.petairbnb.model.*;
import com.edu.petairbnb.service.AccountService;
import com.edu.petairbnb.service.AnimalService;
//import com.edu.petairbnb.service.BookingService;
//import com.edu.petairbnb.service.CarerService;
import com.edu.petairbnb.service.BookingService;
import com.edu.petairbnb.service.CarerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Component
@Profile("generateSampleData")
@RequiredArgsConstructor
public class SampleContentCreator extends BaseComponent implements CommandLineRunner {
    private final AccountService accountService;
    private final AnimalService animalService;
    private final BookingService bookingService;
    private final CarerService carerService;

    @Override
    public void run(String... args) throws Exception{

        logger.warn("adadasdasdasdas");

        List<String> reviews = List.of("a");

        List<Account> account = List.of(Account.builder().firstName("first").lastName("last").email("email").password("password").reviews(reviews).build());

        List<Animal> animals = List.of(Animal.builder().animalType(AnimalType.valueOf("DOG")).age(1).comments("aaa").owner(account.get(0)).build());
        List<String> rules = List.of("a");
        List<Carer> carers = List.of(Carer.builder().rules(rules).petHistory(animals).firstName("FirstName").lastName("LastName").email("Email").password("Password").reviews(reviews).build());

        account.forEach(account1 -> account1.setPetsOwned(animals));


        accountService.createAll(account);

        Booking booking = Booking.builder().date(new Date()).customer(account.get(0)).pets(animals).build();
        bookingService.createAll(booking);

        carerService.createAll(carers);

    }
}
