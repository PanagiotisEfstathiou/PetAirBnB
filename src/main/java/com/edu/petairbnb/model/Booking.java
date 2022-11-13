package com.edu.petairbnb.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(callSuper = true)
@Table(name = "BOOKINGS")
@SequenceGenerator(name = "idGenerator", sequenceName = "BOOKING_SEQ", initialValue = 1, allocationSize = 1)
public class Booking extends BaseModel{

    @Column(length = 20, nullable = false)
    @NotNull
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference("pastBookings")
    private Animal pet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference("pastBookings")
    @NotNull
    private Owner customer;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull
    private Carer carer;

}
