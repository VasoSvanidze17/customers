package ge.toyboom.customers.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Data
public class CustomersSearchParams {
    private String firstName;

    private String lastName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
}
