package io.github.sahawick.sqlrelationdemo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {

    private String name;
    private Double price;
}
