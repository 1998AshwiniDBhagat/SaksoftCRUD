package com.example.crudOperation.Service;

import com.example.crudOperation.Dto.EmployeeDto;

import java.util.List;

/** @createdBy - Ashwini Bhagat **/

public interface EmployeeService {

    EmployeeDto saveEmoployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto getSingleEmployee(Long employeeId);
    EmployeeDto updateEmployee(EmployeeDto employeeDto, Long employeeId);
    void deleteEmployee(Long employeeId);

}
