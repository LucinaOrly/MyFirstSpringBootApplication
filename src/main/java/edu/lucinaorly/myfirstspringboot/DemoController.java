package edu.lucinaorly.myfirstspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// RestController marks class as a request handler (a REST controller).
@RestController
public class DemoController {
    final static String MSG_ADD = "Added new customer to repo!";

    // Autowired tells Spring to inject the customerRepository bean, which is implemented
    // from the  repository interface.
    @Autowired
    private CustomerRepository customerRepository;

    // use POST mapping to save data to repository
    @PostMapping("/add")
    public String addCustomer(@RequestParam String first,
                              @RequestParam String last) {
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);

        return MSG_ADD;
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    // PathVariable maps the value in place of {id} from URL to the corresponding parameter
    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }

}
