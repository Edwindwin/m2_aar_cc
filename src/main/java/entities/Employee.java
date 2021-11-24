package entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Employee {

    @Id @GeneratedValue
    private int id;

    @NonNull
    private String name;

    @NonNull
    private String firstName;

    @NonNull
    private String address;

    @NonNull
    private LocalDate joinDate;

    private LocalDate leaveDate;

    @ManyToOne
    private Service service;

    private String role;
}
