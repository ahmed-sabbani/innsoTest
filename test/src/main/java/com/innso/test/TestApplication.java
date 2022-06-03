package com.innso.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication/*inclus componantscan et configuration*/
// @PropertySource("classpath:application.properties") // le fichier de proporties s'il est à la racine il le retrouve
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	/*@Bean
	public Hibernate5Module datatypeHibernateModule() {
		return new Hibernate5Module();
	}*/


}
