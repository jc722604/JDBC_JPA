package hw2.service.Impl;


import hw2.domain.Employee;
import hw2.domain.EmployeeDTO;
import hw2.exception.EmployeeNotFoundException;
import hw2.repository.EmployeeRepo;
import hw2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EmployeeDTO getEmployeeId(int id) {
        Employee employee = employeeRepo.getEmployeeById(id);
        if(employee == null) {
            throw new EmployeeNotFoundException("Cannot find this id " + id);
        }
        return new EmployeeDTO(employeeRepo.getEmployeeById(id));
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        Collection<Employee> employees = employeeRepo.getAllEmployees();
        return employees.stream().map(s -> new EmployeeDTO(s)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO saveEmployee(Employee employee) {
        if(employeeRepo.getEmployeeById(employee.getId()) != null) {
            throw new EmployeeNotFoundException("Employee already exists");
        }
        employeeRepo.saveEmployee(employee);
        System.out.println("Employee id: " + employee.getId() + ",Name: " + employee.getName());
        return new EmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(int id, String name) {
        Employee employee = employeeRepo.getEmployeeById(id);
        if(employee == null) {
            throw new EmployeeNotFoundException("Cannot find this id " + id);
        }
        return new EmployeeDTO(employeeRepo.updateEmployee(id, name));
    }


}
