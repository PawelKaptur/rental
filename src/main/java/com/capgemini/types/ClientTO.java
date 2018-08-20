package com.capgemini.types;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String city;
    private String street;
    private Integer postalCode;
    private Long phoneNumber;
    private String email;
    private String creditCardNumber;
    private List<Long> rentals;
}
