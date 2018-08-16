package com.capgemini.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "worker")
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    @Column(nullable = false)
    private String occupation;

    @ManyToOne
    @JoinColumn(name = "workplace_id", referencedColumnName = "id")
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
}
