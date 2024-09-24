package com.scaler.bookmyshow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaler.bookmyshow.dtos.SignupRequestDto;
import com.scaler.bookmyshow.dtos.SignupResponseDto;
import com.scaler.bookmyshow.enums.ResponseStatus;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.services.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupResponseDto Signup(SignupRequestDto request) {
        SignupResponseDto response = new SignupResponseDto();
        try {
            User user = userService.signUp(request.getEmail(), request.getPassword());
            response.setUserId(user.getId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.setResponseStatus(ResponseStatus.FAILED);
        }

        return response;

    }
}