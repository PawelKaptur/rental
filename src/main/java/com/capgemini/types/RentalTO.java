package com.capgemini.types;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RentalTO {

    private Long id;
    private Long clientId;
    private Long carId;
    private Date startDate;
    private Date endDate;
    private Long startOutpostId;
    private Long endOutpostId;
    private Integer cost;
}
