package com.scaler.bookmyshow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.scaler.bookmyshow.controllers.UserController;
import com.scaler.bookmyshow.dtos.SignupRequestDto;
import com.scaler.bookmyshow.dtos.SignupResponseDto;

@SpringBootApplication
@EnableJpaAuditing
public class BookmyshowApplication implements CommandLineRunner {
	@Autowired
	UserController userController;

	@Override
	public void run(String... args) throws Exception {
		SignupRequestDto signupRequestDto = new SignupRequestDto();
		signupRequestDto.setEmail("ishan222@gmail.com");
		signupRequestDto.setPassword("password");
		SignupResponseDto response = userController.Signup(signupRequestDto);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookmyshowApplication.class, args);
	}

}
