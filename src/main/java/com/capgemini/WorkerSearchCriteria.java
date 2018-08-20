package com.capgemini;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerSearchCriteria {
    private Long outpostEntity;
    private Long carEntity;
    private String occupation;
}
