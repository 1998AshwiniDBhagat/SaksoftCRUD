package com.example.crudOperation;

import com.example.crudOperation.Model.Employee;
import com.example.crudOperation.Repository.EmployeeRepo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

/** @createdBy - Ashwini Bhagat **/


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;

//    junit test fo save employee
    @Test
    @Order(1)
    @Rollback(value = false)
    public  void saveEmployeeTest(){
        Employee employee= Employee.builder()
                .employeeFName("Raj")
                .employeeLName("Verma")
                .employeeEmail("raj.verma@imagine.com")
                .employeeAge(35)
                .build();

        employeeRepo.save(employee);

        Assertions.assertThat(employee.getEmployeeId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void  getEmployeeTest(){
        Employee employee = employeeRepo.findById(1L).get();

        Assertions.assertThat(employee.getEmployeeId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void  getListEmployeesTest(){

        List<Employee> employees=employeeRepo.findAll();

        Assertions.assertThat(employees.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void  updateEmployeesTest(){

        Employee employee = employeeRepo.findById(1L).get();
        employee.setEmployeeEmail("ravi@gmail.com");
        Employee employeeupdate = employeeRepo.save(employee);

        Assertions.assertThat(employeeupdate.getEmployeeEmail()).isEqualTo("ravi@gmail.com");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){

        Employee employee = employeeRepo.findById(1L).get();
//        employeeRepo.delete(employee);
        employeeRepo.deleteById(1L);
        Employee employee1=null;
        Optional<Employee> optionalEmployee=employeeRepo.findById(1L);

        if(optionalEmployee.isPresent()){
            employee1=optionalEmployee.get();
        }

        Assertions.assertThat(employee1).isNull();
    }
}
