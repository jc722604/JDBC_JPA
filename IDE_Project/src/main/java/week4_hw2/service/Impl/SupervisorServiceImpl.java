package hw2.service.Impl;

import hw2.domain.Employee;
import hw2.domain.EmployeeDTO;
import hw2.domain.Supervisor;
import hw2.domain.SupervisorDTO;
import hw2.exception.EmployeeNotFoundException;
import hw2.exception.SupervisorNotFoundException;
import hw2.repository.SupervisorRepo;
import hw2.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.ServerNotActiveException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    private SupervisorRepo supervisorRepo;

    @Autowired
    public SupervisorServiceImpl(SupervisorRepo supervisorRepo) {
        this.supervisorRepo = supervisorRepo;
    }

    @Override
    public SupervisorDTO getSupervisorId(int id) {
        Supervisor supervisor = supervisorRepo.getSupervisorById(id);
        if(supervisor == null) {
            throw new SupervisorNotFoundException("Cannot find this id " + id);
        }
        return new SupervisorDTO(supervisor);
    }

    @Override
    public List<SupervisorDTO> getAllSupervisors() {
        List<SupervisorDTO> supervisors = supervisorRepo.getAllSupervisors().
                stream().map(s -> new SupervisorDTO(s)).
                collect(Collectors.toList());

        return supervisors;
    }

    @Override
    public SupervisorDTO saveSupervisor(Supervisor supervisor) {
        if(supervisorRepo.getSupervisorById(supervisor.getId()) != null) {
            throw new SupervisorNotFoundException("Supervisor already exists");
        }
        supervisorRepo.saveEmployee(supervisor);
        System.out.println("Supervisor id: " + supervisor.getId() + ",Name: " + supervisor.getName());
        return new SupervisorDTO(supervisor);
    }

    @Override
    public SupervisorDTO updateSupervisor(int id, String name) {
        Supervisor supervisor = supervisorRepo.getSupervisorById(id);
        if(supervisor == null){
            throw new SupervisorNotFoundException("Cannot find this id " + id);
        }
        return new SupervisorDTO(supervisorRepo.updateEmployee(id, name));
    }
}
