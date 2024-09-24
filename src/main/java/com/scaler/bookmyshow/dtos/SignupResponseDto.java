package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.enums.ResponseStatus;

import lombok.Data;

@Data
public class SignupResponseDto {
    private ResponseStatus responseStatus;
    private String message;
    private Long UserId;
}