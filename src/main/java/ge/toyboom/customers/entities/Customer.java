package ge.toyboom.customers.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Customer {
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private Boolean isDeleted;
}
