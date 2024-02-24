package com.codervj.EmployeeApplication.services;

import com.codervj.EmployeeApplication.entity.Employee;
import com.codervj.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * EmployeeService class used as Service which connects the controller and Data Source/Data Repository.
 * It takes the input from controller and fetch the data from Data Source, manipulates the data and gives
 * back to respective controller
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void insertEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.delete(employeeRepository.getReferenceById(id));
    }
}
