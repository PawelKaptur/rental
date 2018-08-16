package com.capgemini.domain;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "outpost")
public class OutpostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false, length = 30)
    private String street;

    @Column(nullable = false)
    private Integer postalCode;

    @Column(nullable = false)
    private Long phoneNumber;

    @Column(length = 50)
    private String email;

    @OneToMany
    private List<WorkerEntity> workers;
}
