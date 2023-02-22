package com.example.crudOperation.Controller;

import com.example.crudOperation.Dto.EmployeeDto;
import com.example.crudOperation.Helper.ApiResponce;
import com.example.crudOperation.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**CreatedBy - Ashwini Bhagat**/
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto saveEmoployee = employeeService.saveEmoployee(employeeDto);
        return new ResponseEntity<>(saveEmoployee, HttpStatus.CREATED);
    }

    @GetMapping("employee/{employeeId}")
    public  ResponseEntity<EmployeeDto> getSingleEmployee(@PathVariable Long employeeId)
    {
        EmployeeDto employee = this.employeeService.getSingleEmployee(employeeId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping("/allemployees")
    public  ResponseEntity<List<EmployeeDto>> getAllEmployee()
    {
        List<EmployeeDto> employee = this.employeeService.getAllEmployee();
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PutMapping("employee/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable Long employeeId)
    {
        EmployeeDto updateEmployee = this.employeeService.updateEmployee(employeeDto, employeeId);
        return new ResponseEntity<>(updateEmployee,HttpStatus.CREATED);
    }

    @DeleteMapping("employees/{employeeId}")
    public ResponseEntity<ApiResponce> deleteEmployee(@PathVariable Long employeeId)
    {
        this.employeeService.deleteEmployee(employeeId);
        return  new ResponseEntity<>(new ApiResponce("employee Delete Suiccessfully", true),HttpStatus.OK);
    }
}
