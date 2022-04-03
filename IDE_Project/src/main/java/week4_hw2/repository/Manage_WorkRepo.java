package hw2.repository;

import hw2.domain.Manage_Work;
import hw2.repository.repo_interface.Manage_WorkInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class Manage_WorkRepo {

    private EmployeeRepo employeeRepo;
    private SupervisorRepo supervisorRepo;

    @Autowired
    private Manage_WorkInter manageWorkInter;

    @Autowired
    public Manage_WorkRepo(SupervisorRepo supervisorRepo, EmployeeRepo employeeRepo) {
        this.supervisorRepo = supervisorRepo;
        this.employeeRepo = employeeRepo;
    }

    public Manage_Work saveManage_Work(int e_id, int s_id) {
        Manage_Work manage_work = new Manage_Work(
                employeeRepo.getEmployeeById(e_id),
                supervisorRepo.getSupervisorById(s_id)
        );
        manageWorkInter.saveAndFlush(manage_work);
        return manage_work;
    }

    public Collection<Manage_Work> getAllSupervisor_Employee() {
        return manageWorkInter.findAll();
    }
}
