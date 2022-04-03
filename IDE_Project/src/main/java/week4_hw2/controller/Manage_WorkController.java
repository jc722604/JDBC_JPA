package hw2.controller;

import hw2.domain.Manage_WorkDTO;
import hw2.service.Manage_WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Manage_WorkController {
    private final Manage_WorkService manageWorkService;

    @Autowired
    public Manage_WorkController(Manage_WorkService manageWorkService) {
        this.manageWorkService = manageWorkService;
    }

    @GetMapping("/manage_work")
    public ResponseEntity<List<Manage_WorkDTO>> getManage_Work() {
        return new ResponseEntity<>(manageWorkService.getAllManage_Work(), HttpStatus.OK);
    }

    @PostMapping("/manage_work/{s_id}/{e_id}")
    public ResponseEntity<Manage_WorkDTO> saveManage_Work(@PathVariable int s_id, @PathVariable int e_id) {
        return new ResponseEntity<>(manageWorkService.saveManage_Work(s_id, e_id), HttpStatus.CREATED);
    }

}
