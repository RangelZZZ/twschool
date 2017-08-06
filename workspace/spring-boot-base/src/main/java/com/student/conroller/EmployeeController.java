package com.student.conroller;

import bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

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


//    @RequestMapping(value = "/employees", method = RequestMethod.GET)
//    public ResponseEntity<List> getEmployees() {
//        return new ResponseEntity<List>(employeeList, HttpStatus.OK);
//    }

//    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Employee> getEmployeesById(@PathVariable("id") int id) {
//        employeeInMemoryService.getEmployee(id);
//        return null;
//
//        for (Employee employee : employeeList) {
//            if (employee.getId() == id) {
//                return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
//
//            }
//        }
//        return new ResponseEntity<>((Employee) null, HttpStatus.OK);
//
//    }

//    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
//        for (Employee employee1 : employeeList) {
//            if (employee1.getId() == id) {
//                employee1.setName(employee.getName());
//                employee1.setAge(employee.getAge());
//
//                return new ResponseEntity<>((Employee) null, HttpStatus.NO_CONTENT);
//            }
//        }
//
//        return new ResponseEntity<>((Employee) null, HttpStatus.NOT_FOUND);
//    }
//
//
//    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) {
//        for (Employee employee1 : employeeList) {
//            if (employee1.getId() == id) {
//                employeeList.remove(employee1);
//                return new ResponseEntity<>((Employee) null, HttpStatus.NO_CONTENT);
//            }
//        }
//        return new ResponseEntity<>((Employee) null, HttpStatus.NOT_FOUND);
//    }
}


