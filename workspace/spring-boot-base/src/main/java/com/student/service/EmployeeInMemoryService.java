package com.student.service;

import com.student.bean.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeInMemoryService implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }

    @Override
    public boolean updateEmployee(int id, Employee employee) {
        for (Employee employee1 : employees) {
            if (employee1.getId() == id) {
                employee1.setAge(employee.getAge());
                employee1.setId(id);
                employee1.setName(employee.getName());

                return true;
            }

        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        for (Employee employee1 : employees) {
            if (employee1.getId() == id) {
                employees.remove(employee1);
                return true;
            }

        }
        return false;

    }


}
