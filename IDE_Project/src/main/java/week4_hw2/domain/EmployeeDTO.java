package hw2.domain;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDTO {

    private int id;
    private String full_name;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.full_name = employee.getName();
    }
}
