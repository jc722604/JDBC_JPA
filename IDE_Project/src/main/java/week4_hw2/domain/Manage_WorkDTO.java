package hw2.domain;

import lombok.Data;

@Data
public class Manage_WorkDTO {

    private int id;
    private String employeeName;
    private String supervisorName;

    public Manage_WorkDTO(Manage_Work _supervisorEmployee) {
        this.id = _supervisorEmployee.getId();
        this.employeeName = _supervisorEmployee.getEmployee().getName();
        this.supervisorName = _supervisorEmployee.getSupervisor().getName();
    }
}
