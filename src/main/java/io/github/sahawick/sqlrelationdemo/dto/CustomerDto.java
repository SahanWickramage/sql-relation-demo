package io.github.sahawick.sqlrelationdemo.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    private Long id;
    private String name;
    private String email;
    private List<OrderDto> orders;
}
