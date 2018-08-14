package com.capgemini.domain;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "outposts")
public class OutpostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;


    //osobne entity do adresow?
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

    private Date dateOfCreating;

    private Date dateOfEditing;
}
