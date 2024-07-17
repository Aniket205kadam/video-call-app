package dev.aniket.VideoCallApp;

import dev.aniket.VideoCallApp.user.User;
import dev.aniket.VideoCallApp.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoCallAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoCallAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserService service
	) {
		return args -> {
			service.register(User
					.builder()
					.username("aniket205kadam")
					.email("aniketrkadam205@gmail.com")
					.password("2004")
					.build());

			service.register(User
					.builder()
					.username("rohit45sharma")
					.email("rohit.sharma.45@gmail.com")
					.password("1234")
					.build());

			service.register(User
					.builder()
					.username("its_rohini")
					.email("rohini@gmail.com")
					.password("1234")
					.build());
		};
	}

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