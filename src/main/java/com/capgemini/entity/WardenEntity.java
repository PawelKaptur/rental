package com.capgemini.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "wardens")
public class WardenEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @Column(nullable = false)
    private WorkerEntity workerId;

    @ManyToOne
    @Column(nullable = false)
    private CarEntity carId;

    private Date dateOfCreating;

    private Date dateOfEditing;
}
