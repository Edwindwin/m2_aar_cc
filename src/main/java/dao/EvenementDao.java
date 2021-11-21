package dao;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter @AllArgsConstructor
public class EvenementDao {
    private int idEvt;
    private String dateEvt;
    private String description;
    private List<EmployeMinimalDao> concerne;
}
