package ge.toyboom.customers.repositories;

import ge.toyboom.customers.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
