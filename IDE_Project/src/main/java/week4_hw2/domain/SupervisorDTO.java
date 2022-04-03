package hw2.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SupervisorDTO {

    private int id;
    private String full_name;
    private Date date;

    public SupervisorDTO(Supervisor supervisor) {
        this.id = supervisor.getId();
        this.full_name = supervisor.getName();
        this.date = new Date();
    }
}
