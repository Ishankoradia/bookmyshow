package com.scaler.bookmyshow.dtos;

import lombok.Data;

@Data
public class SignupRequestDto {
    String email;
    String password;
}