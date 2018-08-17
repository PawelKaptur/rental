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
    private Date dateOfBirth;
    private String city;
    private String street;
    private Integer postalCode;
    private Long phoneNumber;

    //private OutpostTO workplaceId;
    private Long workplaceId;

}
