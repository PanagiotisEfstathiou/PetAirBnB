package com.edu.petairbnb.model;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(callSuper = true)
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


}
