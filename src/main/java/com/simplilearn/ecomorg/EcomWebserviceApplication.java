package com.simplilearn.ecomorg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring Boot auto-configuration :- @SpringBootApplication=@ComponentScan+@EnableAutoConfiguration+@Configuration
// @ComponentScan :- It is used for scanning spring components, services, confrigration , bean , controller etc.
// @EnableAutoConfiguration  :- annotation enables the auto-configuration of Spring ApplicationContext by scanning the classpath components and registering the beans.
// @Configuration :- System level configuration, ex. JVM config
@SpringBootApplication
public class EcomWebserviceApplication {

	// start pointing of application
	public static void main(String[] args) {
		SpringApplication.run(EcomWebserviceApplication.class, args);
	}

}
