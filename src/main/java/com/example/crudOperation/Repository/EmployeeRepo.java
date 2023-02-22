package com.example.crudOperation.Repository;

import com.example.crudOperation.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/** @createdBy - Ashwini Bhagat **/

@Repository
public interface EmployeeRepo extends JpaRepository <Employee, Long> {



}
