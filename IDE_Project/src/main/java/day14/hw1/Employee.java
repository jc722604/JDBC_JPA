package day14.hw1;

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
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Supervisor_Employee> supervisor_employees = new ArrayList<>();

    public List<Supervisor_Employee> getSupervisor_Employee(){ return supervisor_employees; }

    public void setSupervisor_Employee(List<Supervisor_Employee> se) { this.supervisor_employees = se; }

    public void addSupervisor_Employee(Supervisor_Employee se) { this.supervisor_employees.add(se); }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) && first_name.equals(employee.first_name) && last_name.equals(employee.last_name) && supervisor_employees.equals(employee.supervisor_employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, supervisor_employees);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
