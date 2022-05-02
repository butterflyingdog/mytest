package myspringbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class MySpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootDemoApplication.class, args);
	}

}
