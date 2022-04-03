package hw2.service;

import hw2.domain.Manage_WorkDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Manage_WorkService {
    List<Manage_WorkDTO> getAllManage_Work();
    Manage_WorkDTO saveManage_Work(int s_id, int e_id);
}
