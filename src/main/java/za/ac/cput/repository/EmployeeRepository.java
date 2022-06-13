package za.ac.cput.repository;

import za.ac.cput.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private List<Employee> employeeList;

    private EmployeeRepository() {
        this.employeeList = new ArrayList<>();
    }

    public Employee create(Employee employee) { //save into data store and return if success
        return employee;
    }

    public Employee update(Employee employee) { //check if employee exists, if yes, update and return if success
        return employee;
    }

    public Employee read(String staffId) { //find the employee that matches the staffId and return
        return null;
    }

    public void delete(Employee employee) { //find the employee if needed and delete

    }

    public List<Employee> findAll() { //return all in your store
        return null;
    }
}
