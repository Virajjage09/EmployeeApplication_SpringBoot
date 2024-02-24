package com.codervj.EmployeeApplication.repository;

import com.codervj.EmployeeApplication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmployeeRepository extends the JpaRepository which helps to
 * perform in built CRUD operations
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
