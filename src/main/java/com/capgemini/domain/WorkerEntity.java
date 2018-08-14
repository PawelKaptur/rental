package com.capgemini.domain;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "workers")
public class WorkerEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    //moze enum albo osobne entity zrobic
    @Column(nullable = false)
    private String occupation;

    @ManyToOne
    private OutpostEntity workplaceId;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false, length = 30)
    private String street;

    @Column(nullable = false)
    private Integer postalCode;

    @Column(nullable = false)
    private Long phoneNumber;

    @Column(nullable = false)
    private Date dateOfCreating;

    private Date dateOfEditing;
}
