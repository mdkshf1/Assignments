package com.Ayush.SpringAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAssignmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringAssignmentApplication.class, args);
		Car car = new Car(new Audi());
		car.H();
	}

}
