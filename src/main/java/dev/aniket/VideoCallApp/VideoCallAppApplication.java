package dev.aniket.VideoCallApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VideoCallAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoCallAppApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(
//			UserService service
//	) {
//		return args -> {
//			service.register(new User(
//					"aniket",
//					"aniket@gmail.com",
//					"password",
//					"online"));
//
//			service.register(new User(
//					"rohit",
//					"rohit@gmail.com",
//					"password",
//					"online"));
//		};
//	}

}

/*
* CommandLineRunner is an interface in Spring Boot that can be implemented to run
* specific pieces of code after the Spring application context has been fully initialized.
* It’s useful for executing startup logic, such as loading data, initializing settings,
* or performing any other task that should occur when the application starts.
*
* When you create a bean that implements CommandLineRunner, the run method of that
* bean is executed after the Spring application context is fully initialized and the
* application is running.
* */