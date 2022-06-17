/*
    Shasta Abrahams - 217059376
    EmployeeRepository.java
    11 June 2022
 */
/*package za.ac.cput.repository;

import za.ac.cput.domain.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeRepository { //implements IEmployeeRepository
    private final List<Employee> employeeList;
    private static EmployeeRepository EMPLOYEE_REPOSITORY;

    private EmployeeRepository() {
        this.employeeList = new ArrayList<>();
    }

    public static EmployeeRepository employeeRepository() {
        if (EMPLOYEE_REPOSITORY == null)
            EMPLOYEE_REPOSITORY = new EmployeeRepository();
        return EMPLOYEE_REPOSITORY;
    }

    public Employee save(Employee employee) { //if employee exists then it updates, if it doesn't exist then it creates employee
        Optional<Employee> read = read(employee.getStaffId());
        if(read.isPresent()) {
            delete(read.get());
        }
        this.employeeList.add(employee);
        return employee;
    }

    public Optional <Employee> read(String staffId) { //find the employee that matches the staffId and return
        return this.employeeList.stream().filter(e -> e.getStaffId().equalsIgnoreCase(staffId))
                .findFirst();
    }

    public void delete(Employee employee) {
        this.employeeList.remove(employee);
    }

    public List<Employee> findAll() {
        return this.employeeList;
    }

    //public List<Employee> findByStaffId(String staffId) {
    //    return this.employeeList.stream().filter(e -> e.getStaffId().equalsIgnoreCase(staffId))
    //            .collect(Collectors.toList());
    //}
}

 */

