package com.student.service;

import com.student.bean.Address;
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
                employee1.setMailAddress(employee.getMailAddress());
                employee1.setOriginalAddress(employee.getOriginalAddress());

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

    @Override
    public boolean updateEmployeeAddressById(int id, String addressType, Address address) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                updateAddress(employee,addressType, address);

                return true;
            }
        }

        return false;
    }

    private void updateAddress(Employee employee,String addressType, Address address) {
        if(addressType.equals("mailAddress")){
            employee.setMailAddress(address);
        }else{
            employee.setOriginalAddress(address);
        }
    }
}
