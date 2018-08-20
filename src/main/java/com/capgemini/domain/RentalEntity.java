package com.capgemini.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "rental")
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
