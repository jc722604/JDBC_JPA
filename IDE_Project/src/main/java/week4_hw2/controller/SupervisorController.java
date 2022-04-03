package hw2.controller;

import hw2.domain.Supervisor;
import hw2.domain.SupervisorDTO;
import hw2.exception.EmployeeNotFoundException;
import hw2.exception.SupervisorNotFoundException;
import hw2.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class SupervisorController {

    private final SupervisorService supervisorService;

    @Autowired
    public SupervisorController(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }

    @GetMapping("/supervisor")
    public ResponseEntity<List<SupervisorDTO>> getAllSupervisor() {
        return new ResponseEntity<>(supervisorService.getAllSupervisors(), HttpStatus.OK);
    }

    @GetMapping("/supervisor/{id}")
    public ResponseEntity<SupervisorDTO>getSupervisorById(@PathVariable int id) {
        return new ResponseEntity<>(supervisorService.getSupervisorId(id), HttpStatus.OK);
    }

    @PostMapping("/supervisor/{name}")
    public ResponseEntity<SupervisorDTO> saveSupervisor(@PathVariable String name) {
        Supervisor supervisor = new Supervisor();
        supervisor.setName(name);
        return new ResponseEntity<>(supervisorService.saveSupervisor(supervisor), HttpStatus.CREATED);
    }

    @PutMapping("/supervisor/{id}/{newName}")
    public ResponseEntity<SupervisorDTO> updateSupervisor(@PathVariable int id, @PathVariable String newName) {
        return new ResponseEntity<>(supervisorService.updateSupervisor(id, newName), HttpStatus.OK);
    }

    @ExceptionHandler(SupervisorNotFoundException.class)
    public ResponseEntity<?> customizedExceptionHandler() {
        //get internal error
        return new ResponseEntity<>("Employee not found. You may get something wrong. ", HttpStatus.NOT_FOUND);
    }
}
