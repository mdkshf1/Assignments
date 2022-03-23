package com.mappinginjpa;

import com.mappinginjpa.entities.Address;
import com.mappinginjpa.entities.Author;
import com.mappinginjpa.entities.Subject;
import com.mappinginjpa.repos.Repository;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
public class MappinginjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappinginjpaApplication.class, args);

		Author author = new Author();

		author.setAuthorid(101);
		author.setAuthorname("Kashif");


		Address address = new Address();
		address.setStreetnumber(101);
		address.setLocation("NYC");
		address.setState("NYC");
		author.setAddress(address);

		Subject subject1 = new Subject();
		subject1.setSubjectname("ABC");

		Subject subject2 = new Subject();
		subject2.setSubjectname("XYZ");

		Subject subject3 = new Subject();
		subject3.setSubjectname("PQR");


		ArrayList<Subject> list = new ArrayList<>();
		list.add(subject1);
		list.add(subject2);
		list.add(subject3);

		author.setSubjectList(list);


		System.out.println(author);
	}
}
