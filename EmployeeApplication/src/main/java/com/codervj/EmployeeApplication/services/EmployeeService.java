package com.codervj.EmployeeApplication.services;

import com.codervj.EmployeeApplication.entity.Employee;
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

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "Viraj Jage", "Mumbai"),
            new Employee(2, "Test User 1", "Pune"),
            new Employee(3, "Test User 2", "Bengaluru"),
            new Employee(4, "Test User 3", "Chennai")
    ));

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployee(int id) {
        return employeeList.stream().filter(employee ->
                employee.getEmployeeId() == id
        ).findFirst().get();
    }

    public void insertEmployee(Employee employee) {
       employeeList.add(employee);
    }

    public void updateEmployee(Employee employee) {
        List<Employee> tempEmployeeList = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId() == employee.getEmployeeId()) {
                emp.setEmployeeName(employee.getEmployeeName());
                emp.setEmployeeCity(employee.getEmployeeCity());
            }
            tempEmployeeList.add(emp);
        }
        this.employeeList = tempEmployeeList;
    }

    public void deleteEmployee(int id) {
        employeeList.removeIf(emp -> emp.getEmployeeId() == id);
    }
}
