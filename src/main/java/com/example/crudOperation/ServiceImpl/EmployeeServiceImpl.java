package com.example.crudOperation.ServiceImpl;

import com.example.crudOperation.Dto.EmployeeDto;
import com.example.crudOperation.Exception.ResourceNotFoundException;
import com.example.crudOperation.Model.Employee;
import com.example.crudOperation.Repository.EmployeeRepo;
import com.example.crudOperation.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/** @createdBy - Ashwini Bhagat **/


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto saveEmoployee(EmployeeDto employeeDto) {
        Employee employee = this.modelMapper.map(employeeDto, Employee.class);
        Employee saveemployee = this.employeeRepo.save(employee);
        return this.modelMapper.map(saveemployee,EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> list = this.employeeRepo.findAll();
        List<EmployeeDto> employeeDtos = list.stream().map((employee -> this.modelMapper.map(employee, EmployeeDto.class))).collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public EmployeeDto getSingleEmployee(Long employeeId) {
        Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee Data Not Found On Server!!"));
        return this.modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long employeeId) {
        Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee Data Not Found On server"));
        employee.setEmployeeFName(employeeDto.getEmployeeFName());
        employee.setEmployeeLName(employeeDto.getEmployeeLName());
        employee.setEmployeeEmail(employeeDto.getEmployeeEmail());
        employee.setEmployeeAge(employeeDto.getEmployeeAge());
        Employee updateEmployee = this.employeeRepo.save(employee);
        return this.modelMapper.map(updateEmployee,EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee Data Not Found On Server"));
        this.employeeRepo.delete(employee);

    }
}
