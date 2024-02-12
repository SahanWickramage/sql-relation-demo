package io.github.sahawick.sqlrelationdemo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private String paymentMethod;
    private String status;
}
