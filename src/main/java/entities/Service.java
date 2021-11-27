package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Service {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String mission;

    @OneToMany(
            mappedBy = "parentService")
    private List<Service> sousService;

    @ManyToOne
    private Service parentService;

    @OneToMany(mappedBy = "employes")
    private List<Employe> listeEmployes;
}
