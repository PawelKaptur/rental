package com.capgemini.entity;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "cars")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Setter(AccessLevel.NONE)
    private Long id;

    //enum? moze osobne entity
    private String carType;

    //@Column(nullable = false, length = 30)
    private String brand;

    //@Column(nullable = false, length = 30)
    private String model;

    //@Column(nullable = false)
    private Long productionYear;

   // @Column(nullable = false, length = 30)
    private String color;

   // @Column(nullable = false)
    private Double engineCapacity;

    //@Column(nullable = false)
    private Integer power;

    //@Column(nullable = false)
    private Integer course;


/*    @ManyToOne
    private OutpostEntity currentLocationId;*/

    private Date dateOfCreating;

    private Date dateOfEditing;

    @PrePersist
    protected void onCreate(){
        dateOfCreating = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        dateOfEditing = new Date();
    }

}
