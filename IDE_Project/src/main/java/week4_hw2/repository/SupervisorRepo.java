package hw2.repository;

import hw2.domain.Employee;
import hw2.domain.Supervisor;
import hw2.repository.repo_interface.Supervisor_Inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class SupervisorRepo {
    @Autowired
    private Supervisor_Inter supervisor_inter;

    private Map<String, Supervisor> supervisorMap = new HashMap<>();


    public Supervisor getSupervisorById(int id) {
        return supervisor_inter.findEmployeeById(id);
    }

    public Collection<Supervisor> getAllSupervisors() {
        return supervisor_inter.findAll();
    }

    public Supervisor saveEmployee(Supervisor supervisor) {

        return supervisor_inter.saveAndFlush(supervisor);
    }

    public Supervisor updateEmployee(int id, String newName) {
        Supervisor sup = supervisor_inter.findEmployeeById(id);
        sup.setName(newName);

        return supervisor_inter.saveAndFlush(sup);
    }



}
