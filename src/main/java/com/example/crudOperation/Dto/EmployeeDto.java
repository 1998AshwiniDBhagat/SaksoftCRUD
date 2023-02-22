package com.example.crudOperation.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** @createdBy - Ashwini Bhagat **/

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long employeeId;
    private String employeeFName;
    private  String employeeLName;
    private String employeeEmail;
    private  Integer employeeAge;

}
