package com.edu.petairbnb.model;

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

    @OneToMany
    @Column(nullable = false)
    @NotNull
    private List<Animal> pets;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull
    private Account customer;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull
    private Account carer;

}
