package com.student.service;

import com.student.bean.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);

    boolean updateEmployee(int id, Employee employee);

    boolean deleteEmployee(int id);
}
