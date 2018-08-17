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
//@NamedQuery(name="books.findBooksByAuthor", query="select b from BookEntity b join b.authors a where a.id = :authorId")
//select workers from OutpostEntity outpost where id = outpost.id"
//@NamedQuery(name="outpost.findWorkersByOutpost", query="select workers from OutpostEntity outpost join workers.authors a where a.id = :authorId")
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

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<WorkerEntity> workers;
}
