package hw2.service.Impl;

import hw2.domain.Manage_WorkDTO;
import hw2.repository.Manage_WorkRepo;
import hw2.service.Manage_WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManageWorkImpl implements Manage_WorkService {
    private Manage_WorkRepo manage_work;

    @Autowired
    public ManageWorkImpl(Manage_WorkRepo manage_work) {
        this.manage_work = manage_work;
    }

    @Override
    public List<Manage_WorkDTO> getAllManage_Work() {
        return manage_work.getAllSupervisor_Employee().
                stream().map(es -> new Manage_WorkDTO(es)).
                collect(Collectors.toList());
    }

    @Override
    public Manage_WorkDTO saveManage_Work(int s_id, int e_id) {
        return new Manage_WorkDTO(manage_work.saveManage_Work(s_id, e_id));
    }


}
