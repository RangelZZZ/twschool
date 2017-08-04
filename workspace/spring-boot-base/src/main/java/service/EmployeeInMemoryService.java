package service;

import bean.Employee;

import java.util.LinkedList;
import java.util.List;

public class EmployeeInMemoryService implements EmployeeService {
    private List<Employee> employees = new LinkedList<>();

    @Override
    public Employee getEmployee(String id) {
        return null;
    }
}
