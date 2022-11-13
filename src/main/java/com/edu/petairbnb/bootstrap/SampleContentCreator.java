package com.edu.petairbnb.bootstrap;

import com.edu.petairbnb.base.BaseComponent;
import com.edu.petairbnb.model.*;
import com.edu.petairbnb.service.*;
//import com.edu.petairbnb.service.BookingService;
//import com.edu.petairbnb.service.CarerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Profile("generateSampleData")
@RequiredArgsConstructor
public class SampleContentCreator extends BaseComponent implements CommandLineRunner {
    private final OwnerService ownerService;
    private final AnimalService animalService;
    private final BookingService bookingService;
    private final CarerService carerService;
    private final ReviewService reviewService;


    @Override
    public void run(String... args) throws Exception{

        logger.warn("adadasdasdasdas");






        List<Owner> owner = List.of(Owner.builder().firstName("first").lastName("last").email("email").password("password").build(),
                Owner.builder().firstName("second").lastName("secondLastName").email("email2").password("password").build(),
                Owner.builder().firstName("third").lastName("thirdLastName").email("email3").password("password").build());

        List<Animal> animals = List.of(Animal.builder().name("max").animalType(AnimalType.valueOf("DOG")).age(1).comments("aaa").owner(owner.get(0)).build());
        List<String> rules = List.of("a");

        //owner.forEach(account1 -> account1.setPetsOwned(animals));

        owner.get(0).setPetsOwned(animals);
        //owner.get(0).setReviewsWritten(reviews);


        Carer carer = Carer.builder().firstName("first").lastName("last").email("email").password("password").build();

        List<Review> reviews = List.of(Review.builder().reviewType(ReviewType.GOOD).content("aaa").date(new Date()).build());
        reviews.get(0).setAuthor(owner.get(0));
        reviews.get(0).setReceiver(carer);
        //carer.setReview(reviews);
        carerService.create(carer);
        ownerService.createAll(owner);
        animalService.createAll(animals);
        reviewService.createAll(reviews);
        Booking booking = Booking.builder().date(new Date()).customer(owner.get(0)).carer(carer).pet(animals.get(0)).build();
        bookingService.createAll(booking);


    }
}
