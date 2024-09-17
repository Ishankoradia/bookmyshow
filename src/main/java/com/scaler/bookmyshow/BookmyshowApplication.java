package com.scaler.bookmyshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scaler.bookmyshow.models.BaseModel;

@SpringBootApplication
public class BookmyshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmyshowApplication.class, args);

		BaseModel baseModel = new BaseModel();
		baseModel.getId();
	}

}
