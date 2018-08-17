package com.capgemini.domain;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "rental")
public class RentalEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity clientId;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private CarEntity carId;

    @Column(nullable = false)
    private Date startDate;

    private Date endDate;

    @ManyToOne
    private OutpostEntity startOutpostId;

    @ManyToOne
    private OutpostEntity endOutpostId;

    private Integer cost;

    @Column(nullable = false)
    private Date dateOfCreating;

    private Date dateOfEditing;


}
