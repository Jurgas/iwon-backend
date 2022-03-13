package iwon.iwonbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IwonBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(IwonBackendApplication.class, args);
	}

}
