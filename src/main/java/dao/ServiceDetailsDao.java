package dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ServiceDetailsDao {
    private int id;
    private String nom;
    private String mission;
    private int idParent;
    private List<ServiceMinimalDao> sousservices;
    private List<EmployeMinimalDao> employes;
}
