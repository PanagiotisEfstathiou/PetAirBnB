package com.edu.petairbnb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ANIMALS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ANIMAL_SEQ", initialValue = 1, allocationSize = 1)
public class Animal extends BaseModel {

    @JsonManagedReference("petsOwned")
    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Account owner;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AnimalType animalType;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String name;

    @Column
    private String comments;
}
