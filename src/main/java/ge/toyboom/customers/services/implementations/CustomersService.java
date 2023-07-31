package ge.toyboom.customers.services.implementations;

import ge.toyboom.customers.entities.Customer;
import ge.toyboom.customers.entities.CustomersSearchParams;
import ge.toyboom.customers.exceptions.IllegalArgumentException;
import ge.toyboom.customers.exceptions.NotFoundException;
import ge.toyboom.customers.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CustomersService implements ge.toyboom.customers.services.interfaces.CustomersService {
    private static Long id = 0L;
    private final List<Customer> dataBase = new ArrayList<>();
    private final CustomerRepository customerRepository;

    public CustomersService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomer(CustomersSearchParams customersSearchParams) {
        Stream<Customer> stream = dataBase.stream().filter(customer -> !customer.getIsDeleted());

        String firstName = customersSearchParams.getFirstName();
        if (firstName != null && !firstName.isEmpty()) {
            stream = stream.filter(customer -> customer.getFirstName().equals(firstName));
        }

        String lastName = customersSearchParams.getLastName();
        if (lastName != null && !lastName.isEmpty()) {
            stream = stream.filter(customer -> customer.getLastName().equals(lastName));
        }

        LocalDate birthDate = customersSearchParams.getBirthDate();
        if (birthDate != null) {
            stream = stream.filter((customer -> customer.getBirthDate().equals(birthDate)));
        }

        return stream.toList();
    }

    @Override
    public Customer getCustomer(Long id) {
        if (id < 0) {
            throw new IllegalArgumentException(IllegalArgumentException.ExceptionList.ID_MUST_BE_POSITIVE_INTEGER.getMessage());
        }

        Optional<Customer> customer = dataBase.stream().filter(c -> c.getId().equals(id) && !c.getIsDeleted()).findFirst();
        if (customer.isEmpty()) {
            throw new NotFoundException(NotFoundException.ExceptionList.CUSTOMER_NOT_FOUND.getMessage());
        }

        return customer.get();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customer.setId(id++);
        customer.setIsDeleted(false);
        dataBase.add(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        Customer foundCustomer = getCustomer(id);
        foundCustomer.setFirstName(customer.getFirstName());
        foundCustomer.setLastName(customer.getLastName());
        foundCustomer.setBirthDate(customer.getBirthDate());
        return foundCustomer;
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer foundCustomer = getCustomer(id);
        foundCustomer.setIsDeleted(false); //soft deleting
    }
}
