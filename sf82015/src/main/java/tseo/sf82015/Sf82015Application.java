package tseo.sf82015;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAutoConfiguration
@SpringBootApplication
public class Sf82015Application {

	public static void main(String[] args) {
		SpringApplication.run(Sf82015Application.class, args);
		System.out.println("123");
	}

}
