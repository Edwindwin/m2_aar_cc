package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDetailsDTO {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String dateRecrutement;
    private int idService;
    private String role;
    // TODO Compléter !
    public EmployeDetailsDTO(int id, String nom, String prenom) {
        this.id=id;
        this.prenom=prenom;
        this.nom=nom;
    }
}
