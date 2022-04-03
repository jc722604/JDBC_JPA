package hw2.domain;

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
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Manage_Work> manageWorks = new ArrayList<>();

    private List<Manage_Work> getManageWorks() {
        return manageWorks;
    }

    private void setSupervisor_Employees(List<Manage_Work> manageWorks) {
        this.manageWorks = manageWorks;
    }

    public void addSupervisor_Employee(Manage_Work se) {
        this.manageWorks.add(se);
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
        return id == (that.id) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
