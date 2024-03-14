package com.codervj.EmployeeApplication.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project")
public class Project{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String clientName;

    /**
     * Adding employee object to implement Many to Many mapping
     */
    @ManyToMany(mappedBy = "projects")
    private List<Employee> employee;
    public Project(String name, String clientName) {
        this.name = name;
        this.clientName = clientName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
