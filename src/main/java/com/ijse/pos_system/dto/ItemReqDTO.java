package com.ijse.pos_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemReqDTO {
    private String name;
    private Double price;
    private Long category_id;
}
