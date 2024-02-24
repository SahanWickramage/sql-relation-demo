package io.github.sahawick.sqlrelationdemo.util;

import io.github.sahawick.sqlrelationdemo.dto.CustomerDto;
import io.github.sahawick.sqlrelationdemo.dto.ItemDto;
import io.github.sahawick.sqlrelationdemo.dto.OrderDto;
import io.github.sahawick.sqlrelationdemo.entity.Customer;
import io.github.sahawick.sqlrelationdemo.entity.Item;
import io.github.sahawick.sqlrelationdemo.entity.Order;

import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomerUtils {

    private CustomerUtils() {}

    private static final Function<ItemDto, Item> itemDtoToModel = itemDto -> {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        return item;
    };

    private static final Function<OrderDto, Order> orderDtoToModel = orderDto -> {
        Order order = new Order();
        order.setPaymentMethod(orderDto.getPaymentMethod());
        order.setStatus(orderDto.getStatus());
        order.setCreatedAt(LocalDateTime.now());
        order.setItems(orderDto.getItems().stream().map(itemDtoToModel).collect(Collectors.toList()));
        return order;
    };

    public static Customer mapToModel(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setOrders(customerDto.getOrders().stream().map(orderDtoToModel).collect(Collectors.toList()));
        return customer;
    }

    public static final Function<Item, ItemDto>  itemModelToDto = item -> ItemDto.builder()
            .name(item.getName())
            .price(item.getPrice()).build();

    private static final Function<Order, OrderDto> orderModelToDto = order -> OrderDto.builder()
            .paymentMethod(order.getPaymentMethod())
            .status(order.getStatus())
            .items(order.getItems().stream().map(itemModelToDto).collect(Collectors.toList())).build();

    public static CustomerDto mapToDto(Customer customer) {
        return CustomerDto.builder().id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .orders(customer.getOrders().stream().map(orderModelToDto).collect(Collectors.toList())).build();
    }
}
