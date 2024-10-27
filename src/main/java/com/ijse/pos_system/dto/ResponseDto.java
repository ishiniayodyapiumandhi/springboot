package com.ijse.pos_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto<T> {
    private String message;
    private T data;
}
