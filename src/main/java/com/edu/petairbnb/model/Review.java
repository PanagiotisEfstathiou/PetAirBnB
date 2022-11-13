package com.edu.petairbnb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "REVIEWS")
@SequenceGenerator(name = "idGenerator", sequenceName = "REVIEW_SEQ", initialValue = 1, allocationSize = 1)
public class Review extends BaseModel{
    @Column
    private ReviewType reviewType;
    @Column
    private String content;
    @JsonManagedReference("reviewsWritten")
    @JoinColumn(name = "author")
    @ManyToOne
    private Owner author;
    @Column
    private Date date;
    @ManyToOne
    @JoinColumn(name = "receiver")
    @JsonManagedReference("review")
    private Carer receiver;
}
