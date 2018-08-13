package com.capgemini.entity;


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

    @ManyToOne
    @Column(nullable = false)
    private ClientEntity clientId;

    @ManyToOne
    @Column(nullable = false)
    private CarEntity carId;

    @Column(nullable = false)
    private Date startDate;

    private Date endDate;

    @ManyToOne
    @Column(nullable = false)
    private OutpostEntity startOutpostId;

    @ManyToOne
    private OutpostEntity endOutpostId;

    private Integer cost;

    private Date dateOfCreating;

    private Date dateOfEditing;


}
