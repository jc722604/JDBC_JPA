package hw2.service;

import hw2.domain.Employee;
import hw2.domain.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeDTO getEmployeeId(int id);
    List<EmployeeDTO> getAllEmployees();
//    List<Supervisor_Employee> getSupervisor_EmployeeId(int id);
    EmployeeDTO saveEmployee(Employee employee);
    EmployeeDTO updateEmployee(int id, String name);
}
