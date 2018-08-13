package com.capgemini;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "wardens")
public class WardenEntity {

    //foreign key
    @Column(nullable = false)
    private WorkerEntity workerId;


    //foreign key
    @Column(nullable = false)
    private CarEntity carId;
}
