package com.example.crudOperation.Model;

import lombok.*;

import javax.persistence.*;

/** @createdBy - Ashwini Bhagat **/

@Entity
@Table(name = "EmployeesData")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private   Long employeeId;
    @Column(name = "FirstName",nullable = false)
    private  String employeeFName;
    @Column(name = "LastName",nullable = false)
    private  String employeeLName;
    @Column(name = "Email",nullable = false)
    private  String employeeEmail;
    @Column(name = "Age",nullable = false)
    private  Integer employeeAge;
}
