package io.github.sahawick.sqlrelationdemo.service;

import io.github.sahawick.sqlrelationdemo.dto.CustomerDto;
import io.github.sahawick.sqlrelationdemo.repository.CustomerRepository;
import io.github.sahawick.sqlrelationdemo.util.CustomerUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void saveCustomer(CustomerDto customerDto) {

        customerRepository.save(CustomerUtils.mapToModel(customerDto));
    }
}
