package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter @AllArgsConstructor
public class EvenementDTO {
    private int idEvt;
    private String dateEvt;
    private String description;
    private List<EmployeMinimalDTO> concerne;
}
