package io.github.sahawick.sqlrelationdemo.service;

import io.github.sahawick.sqlrelationdemo.dto.CustomerDto;
import io.github.sahawick.sqlrelationdemo.entity.Customer;
import io.github.sahawick.sqlrelationdemo.exception.CustomerNotFoundException;
import io.github.sahawick.sqlrelationdemo.repository.CustomerRepository;
import io.github.sahawick.sqlrelationdemo.util.CustomerUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void saveCustomer(CustomerDto customerDto) {
        customerRepository.save(CustomerUtils.mapToModel(customerDto));
    }

    public CustomerDto getCustomer(Long customerId) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return CustomerUtils.mapToDto(customer);
        } else {
            throw new CustomerNotFoundException("Customer not found for id: ".concat(String.valueOf(customerId)));
        }
    }
}
