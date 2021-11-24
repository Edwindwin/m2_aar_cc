package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ServiceDetailsDTO {
    private int id;
    private String nom;
    private String mission;
    private int idParent;
    private List<ServiceMinimalDTO> sousservices;
    private List<EmployeMinimalDTO> employes;
}
