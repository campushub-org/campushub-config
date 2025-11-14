package campushub.com.campushub_config_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class CampushubConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampushubConfigServiceApplication.class, args);
	}

}
