package com.edu.petairbnb.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carer extends Account {

    @Column
    @ElementCollection
    private List<String> rules;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Animal> petHistory;
}
