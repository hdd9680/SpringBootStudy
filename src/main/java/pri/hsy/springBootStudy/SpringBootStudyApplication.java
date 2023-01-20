package pri.hsy.springBootStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStudyApplication {

	public static void main(String[] args) {
		System.out.println("ContextPath : " + System.getProperty("server.servlet.context-path"));
		SpringApplication.run(SpringBootStudyApplication.class, args);
	}

}
