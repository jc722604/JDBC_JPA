package day14.hw1;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "supervisor")
@Data
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Supervisor_Employee> supervisor_employees = new ArrayList<>();

    private List<Supervisor_Employee> getSupervisor_employees() {
        return supervisor_employees;
    }

    private void setSupervisor_Employees(List<Supervisor_Employee> supervisor_employees) {
        this.supervisor_employees = supervisor_employees;
    }

    public void addSupervisor_Employee(Supervisor_Employee se) {
        this.supervisor_employees.add(se);
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supervisor that = (Supervisor) o;
        return id.equals(that.id) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
