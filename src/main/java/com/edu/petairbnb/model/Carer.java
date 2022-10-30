package com.edu.petairbnb.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
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
@Table(name = "CARERS")
@SequenceGenerator(name = "idGenerator", sequenceName = "CARER_SEQ", initialValue = 1, allocationSize = 1)
public class Carer extends BaseModel {

    @Column
    @ElementCollection
    private List<String> rules;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Animal> petHistory;

    @Column(length = 20, nullable = false)
    @NotNull
    private String firstName;

    @Column(length = 20, nullable = false)
    @NotNull
    private String lastName;

    @Column(length = 50, nullable = false)
    @NotNull
    private String email;

    @Column(length = 20, nullable = false)
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ElementCollection
    @Column(length = 20, nullable = false)
    private List<String> reviews;

//    @JsonManagedReference("owner")
//    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Column
//    private List<Animal> petsOwned;

}
