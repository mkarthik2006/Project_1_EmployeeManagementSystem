package com.ems.employeemanagement.service;

import com.ems.employeemanagement.entity.Employee;
import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    List<Employee> searchEmployeesByName(String keyword);
}