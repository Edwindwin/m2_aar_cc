package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter @Setter
public class Service {

    @Id @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "parentService", fetch = FetchType.LAZY)
    private List<Service> subService;

    @ManyToOne
    private Service parentService;

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
    private List<Employee> employees;

    private String description;
}
