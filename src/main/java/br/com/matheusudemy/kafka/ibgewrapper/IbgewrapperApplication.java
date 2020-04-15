package br.com.matheusudemy.kafka.ibgewrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IbgewrapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbgewrapperApplication.class, args);
	}

}
