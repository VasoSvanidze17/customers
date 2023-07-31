package ge.toyboom.customers.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private Boolean isDeleted;
}
