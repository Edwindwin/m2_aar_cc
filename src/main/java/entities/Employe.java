package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Employe {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private Date arrivee;
    private Date depart;

    @ManyToOne
    private Service service;
    private String role;

}
