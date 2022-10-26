package com.edu.petairbnb.model;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public class Booking extends BaseModel{

    @Column(length = 20, nullable = false)
    private Date date;

    @Column
    private List<Animal> pets;

    @Column(nullable = false)
    private Account customer;

    @Column(nullable = false)
    private Carer carer;
}
