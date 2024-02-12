package io.github.sahawick.sqlrelationdemo.repository;

import io.github.sahawick.sqlrelationdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
