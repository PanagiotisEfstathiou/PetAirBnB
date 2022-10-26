package com.edu.petairbnb.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(callSuper = true)
public class Booking extends BaseModel{

    @Column(length = 20, nullable = false)
    @NotNull
    private Date date;

    @OneToMany
    @Column
    @NotNull
    private List<Animal> pets;

    @OneToOne
    @Column(nullable = false)
    @NotNull
    private Account customer;

    @OneToOne
    @Column(nullable = false)
    @NotNull
    private Carer carer;
}
