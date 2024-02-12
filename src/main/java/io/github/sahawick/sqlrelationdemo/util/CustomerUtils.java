package io.github.sahawick.sqlrelationdemo.util;

import io.github.sahawick.sqlrelationdemo.dto.CustomerDto;
import io.github.sahawick.sqlrelationdemo.dto.OrderDto;
import io.github.sahawick.sqlrelationdemo.entity.Customer;
import io.github.sahawick.sqlrelationdemo.entity.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomerUtils {

    private CustomerUtils() {}

    private static final Function<OrderDto, Order> mapToModel = orderDto -> {
        Order order = new Order();
        order.setPaymentMethod(orderDto.getPaymentMethod());
        order.setStatus(orderDto.getStatus());
        order.setCreatedAt(LocalDateTime.now());
        return order;
    };

    public static Customer mapToModel(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setOrders(customerDto.getOrders().stream().map(mapToModel).collect(Collectors.toList()));
        return customer;
    }
}
