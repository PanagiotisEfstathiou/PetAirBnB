package com.edu.petairbnb.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Animal extends BaseModel {

    @JoinColumn(nullable = false)
    @ManyToOne
    private Account owner;

    @Column(nullable = false)
    private AnimalType animalType;

    @Column(nullable = false)
    private int age;

    @Column
    private String comments;
}
