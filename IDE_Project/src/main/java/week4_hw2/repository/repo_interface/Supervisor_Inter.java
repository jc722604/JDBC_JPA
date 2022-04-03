package hw2.repository.repo_interface;

import hw2.domain.Employee;
import hw2.domain.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Supervisor_Inter extends JpaRepository<Supervisor, Integer> {

    List<Supervisor> findAll();

    Supervisor findEmployeeById(int id);

//    List<Employee_Supervisor> findEmployee_SupervisorById(int id);

    Supervisor saveAndFlush(Supervisor employee);
}
