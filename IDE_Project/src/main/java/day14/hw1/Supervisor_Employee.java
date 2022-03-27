package day14.hw1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee_supervisor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supervisor_Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "e_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_id")
    private Supervisor supervisor;

    @Override
    public String toString() {
        return "Employee_Supervisor{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supervisor_Employee that = (Supervisor_Employee) o;
        return id.equals(that.id) && employee.equals(that.employee) && supervisor.equals(that.supervisor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, supervisor);
    }
}
