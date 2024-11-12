package com.bits_wilp.fooddeliveryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ResponseDTO {
    private String msg;
    private HttpStatus statusCode;
}
