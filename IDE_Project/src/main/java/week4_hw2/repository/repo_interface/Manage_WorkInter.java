package hw2.repository.repo_interface;

import hw2.domain.Manage_Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Manage_WorkInter extends JpaRepository<Manage_Work, Integer> {

    List<Manage_Work> findAll();

    Manage_Work saveAndFlush(Manage_Work _supervisorEmployee);


}
