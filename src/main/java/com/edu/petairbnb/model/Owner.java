package com.edu.petairbnb.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "OWNERS")
@SequenceGenerator(name = "idGenerator", sequenceName = "OWNER_SEQ", initialValue = 1, allocationSize = 1)
public class Owner extends BaseModel{

    @Column(length = 20, nullable = false)
    @NotNull
    private String firstName;
//fddf
    @Column(length = 20, nullable = false)
    @NotNull
    private String lastName;
//test comment
    @Column(length = 50, nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String email;

    @Column(length = 20, nullable = false)
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonBackReference("owner")
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(nullable = true)
    private List<Animal> petsOwned;


    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(nullable = true)
    @JsonBackReference("author")
    private List<Review> reviewsWritten;

    @OneToMany
    @JsonBackReference("owner")
    private List<Booking> pastBookings;




}
