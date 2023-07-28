package ge.toyboom.customers.controllers;

import ge.toyboom.customers.entities.Customer;
import ge.toyboom.customers.entities.CustomersSearchParams;
import ge.toyboom.customers.services.interfaces.CustomersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    private final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomer(CustomersSearchParams customersSearchParams) {
        List<Customer> customers = customersService.getAllCustomer(customersSearchParams);
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok().body(customersService.getCustomer(id));
    }

    @PostMapping()
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer addedCustomer = customersService.addCustomer(customer);
        var location = UriComponentsBuilder.fromPath("/customers/" + addedCustomer.getId()).build().toUri();
        return ResponseEntity.created(location).body(addedCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        return ResponseEntity.ok().body(customersService.updateCustomer(customer, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customersService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
