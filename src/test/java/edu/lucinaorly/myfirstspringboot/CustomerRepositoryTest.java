package edu.lucinaorly.myfirstspringboot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Customer testCustomer;
    @BeforeEach
    public void setUp() {
        testCustomer = new Customer();
        testCustomer.setFirstName("Homer");
        testCustomer.setLastName("Simpson");
        customerRepository.save(testCustomer);
    }

    @AfterEach
    public void tearDown() {
        customerRepository.delete(testCustomer);
    }

    @Test
    void findCustomerById() {
        Integer id = testCustomer.getId();
        Customer savedCustomer = customerRepository.findById(id)
                .orElse(null);
        assertNotNull(savedCustomer);
        assertEquals(testCustomer.getFirstName(), savedCustomer.getFirstName());
        assertEquals(testCustomer.getLastName(), savedCustomer.getLastName());
    }
    @Test
    void findCustomerByIdAfterUpdate() {
        String updatedFirstName = "Bart";
        testCustomer.setFirstName(updatedFirstName);
        customerRepository.save(testCustomer);

        Customer updatedCustomer = customerRepository.findById(testCustomer.getId()).orElse(null);
        assertNotNull(updatedCustomer);
        assertEquals(updatedFirstName, updatedCustomer.getFirstName());
    }

}
