package hw2.service;

import hw2.domain.Employee;
import hw2.domain.EmployeeDTO;
import hw2.domain.Supervisor;
import hw2.domain.SupervisorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupervisorService {
    SupervisorDTO getSupervisorId(int id);
    List<SupervisorDTO> getAllSupervisors();
    //    List<Supervisor_Employee> getSupervisor_EmployeeId(int id);
    SupervisorDTO saveSupervisor(Supervisor supervisor);
    SupervisorDTO updateSupervisor(int id, String name);
}
