package com.capgemini.types;


import com.capgemini.domain.OutpostEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String occupation;

    //outpostentity czy dao, czy id
    private OutpostEntity workplaceId;
    private Date dateOfBirth;
    private String city;
    private String street;
    private Integer postalCode;
    private Long phoneNumber;

    public static class WorkerToBuilder{
        private Long id;
        private String firstName;
        private String lastName;
        private String occupation;
        private OutpostEntity workplaceId;
        private Date dateOfBirth;
        private String city;
        private String street;
        private Integer postalCode;
        private Long phoneNumber;
    }
}
