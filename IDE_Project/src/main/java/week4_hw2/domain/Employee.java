package hw2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;


    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Manage_Work> manageWorks = new ArrayList<>();

    public List<Manage_Work> getSupervisor_Employee(){ return manageWorks; }

    public void setSupervisor_Employee(List<Manage_Work> se) { this.manageWorks = se; }

    public void addSupervisor_Employee(Manage_Work se) { this.manageWorks.add(se); }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == (employee.id) && name.equals(employee.name) && manageWorks.equals(employee.manageWorks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manageWorks);
    }

}
