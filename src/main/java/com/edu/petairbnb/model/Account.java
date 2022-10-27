package com.edu.petairbnb.model;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(callSuper = true)
@Table(name = "ACCOUNTS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNT_SEQ", initialValue = 1, allocationSize = 1)
public class Account extends BaseModel{

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
    private String password;

    @ElementCollection
    @Column(length = 20, nullable = false)
    private List<String> reviews;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column
    private List<Animal> petsOwned;
}
