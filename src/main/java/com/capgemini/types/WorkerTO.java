package com.capgemini.types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkerTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String occupation;

    //outpostentity czy dao, czy id, na razie id, relacje dodac
    //private Long workplaceId;
    private OutpostTO workplaceId;
    private Date dateOfBirth;
    private String city;
    private String street;
    private Integer postalCode;
    private Long phoneNumber;

}
