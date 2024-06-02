package edu.lucinaorly.springfibonacci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class SpringFibonacciApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFibonacciApplication.class, args);
	}

	/* Use @GetMapping annotation to map the method to GET requests for `/hello`.
	 */
	@GetMapping("/hello")
	public String sayHello(@RequestParam(value="myName", defaultValue="World") String name) {
		return String.format("Hello %s!", name);
	}

}
