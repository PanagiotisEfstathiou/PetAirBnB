package com.edu.petairbnb.bootstrap;

import com.edu.petairbnb.base.BaseComponent;
import com.edu.petairbnb.model.*;
import com.edu.petairbnb.service.AccountService;
import com.edu.petairbnb.service.AnimalService;
//import com.edu.petairbnb.service.BookingService;
//import com.edu.petairbnb.service.CarerService;
import com.edu.petairbnb.service.BookingService;
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


    @Override
    public void run(String... args) throws Exception{

        logger.warn("adadasdasdasdas");

        List<String> reviews = List.of("a","b","c","d","f");
        List<String> reviews2 = List.of("a");



        List<Account> account = List.of(Account.builder().firstName("first").lastName("last").email("email").password("password").reviews(reviews).build(),
                Account.builder().firstName("second").lastName("secondLastName").email("email2").password("password").reviews(reviews2).build(),
                Account.builder().firstName("third").lastName("thirdLastName").email("email3").password("password").expertise(Expertise.DOG).build());

        List<Animal> animals = List.of(Animal.builder().name("max").animalType(AnimalType.valueOf("DOG")).age(1).comments("aaa").owner(account.get(0)).build());
        List<String> rules = List.of("a");

        //account.forEach(account1 -> account1.setPetsOwned(animals));

        account.get(0).setPetsOwned(animals);


        accountService.createAll(account);

        Booking booking = Booking.builder().date(new Date()).customer(account.get(0)).carer(account.get(1)).pets(animals).build();
        bookingService.createAll(booking);


    }
}
