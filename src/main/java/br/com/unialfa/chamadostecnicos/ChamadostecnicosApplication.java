package br.com.unialfa.chamadostecnicos;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChamadostecnicosApplication {



	public static void main(String[] args) {
		SpringApplication.run(ChamadostecnicosApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {



		return null;
	}

}
