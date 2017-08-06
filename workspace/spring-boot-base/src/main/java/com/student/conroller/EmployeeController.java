package com.student.conroller;

import com.student.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.student.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity<List> getEmployees() {

        return new ResponseEntity<List>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeesById(@PathVariable("id") int id) {
        if (employeeService.getEmployeeById(id) == null) {
            return new ResponseEntity<>((Employee) null, HttpStatus.OK);
        }

        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }


    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        if (employeeService.updateEmployee(id, employee) == true) {

            return new ResponseEntity<>((Employee) null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>((Employee) null, HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) {
        if (employeeService.deleteEmployee(id) == true) {
            return new ResponseEntity<>((Employee) null, HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>((Employee) null, HttpStatus.NOT_FOUND);
    }
}


