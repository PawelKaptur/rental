package com.capgemini.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CAR")
@Data
public class CarEntity {

    @Id
    @GeneratedValue
    private Long id;

    //enum? moze osobne entity
    @Column(nullable = false)
    private String carType;

    @Column(nullable = false, length = 30)
    private String brand;

    @Column(nullable = false, length = 30)
    private String model;

    @Column(nullable = false)
    private Integer productionYear;

    @Column(nullable = false, length = 30)
    private String color;

    @Column(nullable = false)
    private Double engineCapacity;

    @Column(nullable = false)
    private Integer power;

    @Column(nullable = false)
    private Integer course;

    @Column(nullable = false)
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
