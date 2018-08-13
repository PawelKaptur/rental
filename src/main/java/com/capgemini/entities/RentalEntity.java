package com.capgemini.entities;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "rentals")
public class RentalEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    //foreign key
    @Column(nullable = false)
    private ClientEntity clientId;

    //foreign key
    @Column(nullable = false)
    private CarEntity carId;

    @Column(nullable = false)
    private Date startDate;

    private Date endDate;

    //foreign key
    @Column(nullable = false)
    private OutpostEntity startOutpostId;

    //foreign key
    private OutpostEntity endOutpostId;

    private Integer cost;

    private Date dateOfCreating;

    private Date dateOfEditing;


}
