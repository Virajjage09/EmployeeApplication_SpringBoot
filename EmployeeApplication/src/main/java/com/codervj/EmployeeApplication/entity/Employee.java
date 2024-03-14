package com.codervj.EmployeeApplication.entity;

import jakarta.persistence.*;

import java.util.List;

/**
 * Employee entity helps to keep record of an employee details which are fetched from
 * DataSource
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int employeeId;
    String employeeName;
    String employeeCity;

    /**
     * One to One mapping between Employee and Spouse
     */
    @OneToOne
    @JoinColumn(name = "fk_spouse")
    private Spouse spouse;

    /**
     * One to Many mapping between Employee and Address
     */
    @OneToMany
    private List<Address> addresses;

    /**
     * Many to Many mapping between Employee and Project
     */
    @ManyToMany
    @JoinTable(name = "employee_project",
            joinColumns = @JoinColumn(name = "fk_employee"),
            inverseJoinColumns = @JoinColumn(name = "fk_project"))
    private List<Project> projects;

    public Employee() {

    }

    public Employee(int employeeId, String employeeName, String employeeCity) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void removeProject(Project project) {
        this.projects.remove(project);
        project.getEmployee().remove(this);
    }

    public void addProject(Project project) {
        this.projects.add(project);
        project.getEmployee().add(this);
    }
}
