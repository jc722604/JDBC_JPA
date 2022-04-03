package hw2.repository;

import hw2.domain.Employee;
import hw2.repository.repo_interface.EmployeeRepo_Inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepo {
    @Autowired
    private EmployeeRepo_Inter employeeRepo_inter;

    private Map<String, Employee> employeeMap = new HashMap<>();

    public Employee getEmployeeById(int id) {
        return employeeRepo_inter.findEmployeeById(id);
    }

    public Collection<Employee> getAllEmployees() {
        return employeeRepo_inter.findAll();
    }

    public Employee saveEmployee(Employee employee) {

        return employeeRepo_inter.saveAndFlush(employee);
    }

    public Employee updateEmployee(int id, String newName) {
        Employee emp = employeeRepo_inter.findEmployeeById(id);
        emp.setName(newName);

        return employeeRepo_inter.saveAndFlush(emp);
    }
}
