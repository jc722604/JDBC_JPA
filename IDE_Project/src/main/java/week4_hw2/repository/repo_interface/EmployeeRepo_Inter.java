package hw2.repository.repo_interface;

import hw2.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo_Inter extends JpaRepository<Employee, Integer> {

    List<Employee> findAll();

    Employee findEmployeeById(int id);

    List<Manage_WorkInter> findEmployee_SupervisorById(int id);

    Employee saveAndFlush(Employee employee);
}
