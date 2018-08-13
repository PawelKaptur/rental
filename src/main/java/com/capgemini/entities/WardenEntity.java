package com.capgemini.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

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

    private Date dateOfCreating;

    private Date dateOfEditing;
}
