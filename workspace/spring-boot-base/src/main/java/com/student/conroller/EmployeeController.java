package com.student.conroller;

import bean.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    Map<Integer, Employee> employees = new HashMap<>();

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee) {
        employee.setId(1);
        employees.put(1, employee);

        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity<Map<Integer, Employee>> getEmployees() {

        return new ResponseEntity<Map<Integer, Employee>>(employees, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<Integer, Employee>> getEmployeesById(@PathVariable("id") int id) {
        System.out.println(id);
        if (employees.get(id) == null) {
            return new ResponseEntity<>((Map<Integer, Employee>) null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Map<Integer, Employee>>(employees, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<Integer, Employee>> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        if (employees.get(id) == null) {
            return new ResponseEntity<>((Map<Integer, Employee>) null, HttpStatus.NOT_FOUND);
        }

        employees.get(1).setName(employee.getName());
        employees.get(1).setAge(employee.getAge());

        return new ResponseEntity<Map<Integer, Employee>>((Map<Integer, Employee>) null, HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<Integer, Employee>> deleteEmployee(@PathVariable("id") int id) {
        if (employees.get(id) == null) {
            return new ResponseEntity<>((Map<Integer, Employee>) null, HttpStatus.NOT_FOUND);
        }

        employees.remove(employees.get(id));
        return new ResponseEntity<Map<Integer, Employee>>((Map<Integer, Employee>) null, HttpStatus.NO_CONTENT);
    }

}
