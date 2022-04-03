package hw2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="manage_work")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manage_Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "e_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_id")
    private Supervisor supervisor;

    public Manage_Work(Employee employee, Supervisor supervisor) {
        this.employee = employee;
        this.supervisor = supervisor;
    }

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
        Manage_Work that = (Manage_Work) o;
        return id == (that.id) && employee.equals(that.employee) && supervisor.equals(that.supervisor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, supervisor);
    }
}
