package ge.toyboom.customers.services.interfaces;

import ge.toyboom.customers.CustomersApplication;
import ge.toyboom.customers.entities.Customer;
import ge.toyboom.customers.entities.CustomersSearchParams;

import java.util.List;
import java.util.Locale;

public interface CustomersService {
    List<Customer> getAllCustomer(CustomersSearchParams customersSearchParams);
    Customer getCustomer(Long id);
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer, Long id);
    void deleteCustomer(Long id);
}
