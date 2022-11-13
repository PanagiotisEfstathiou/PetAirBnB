package com.edu.petairbnb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "CARERS")
@SequenceGenerator(name = "idGenerator", sequenceName = "CARER_SEQ", initialValue = 1, allocationSize = 1)
public class Carer extends BaseModel {

    @Column(length = 20, nullable = false)
    @NotNull
    private String firstName;

    @Column(length = 20, nullable = false)
    @NotNull
    private String lastName;

    @Column(length = 50, nullable = false)
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;

    @Column(length = 20, nullable = false)
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    @Column(nullable = true)
    @JsonBackReference("receiver")
    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> review;

    //rules will become an enum and the app will have a standard set of rules
    @Column(nullable = true)
    @ElementCollection
    private List<String> rules;

    @Column(nullable = true)
    private Expertise expertise;

    @Column
    @JsonBackReference("carer")
    @OneToMany
    private List<Booking> pastBookings;

}