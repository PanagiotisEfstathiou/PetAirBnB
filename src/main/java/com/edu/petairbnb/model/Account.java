package com.edu.petairbnb.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@ToString
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ElementCollection
    @Column(length = 20, nullable = false)
    private List<String> reviews;

    @JsonManagedReference("owner")
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column
    private List<Animal> petsOwned;
}
