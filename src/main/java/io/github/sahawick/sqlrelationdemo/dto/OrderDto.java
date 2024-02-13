package io.github.sahawick.sqlrelationdemo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private String paymentMethod;
    private String status;
    private List<ItemDto> items;
}
