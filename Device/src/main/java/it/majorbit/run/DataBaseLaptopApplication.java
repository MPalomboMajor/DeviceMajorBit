package it.majorbit.run;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("it.majorbit.repository")
@EntityScan("it.majorbit.model")
@ComponentScan("it.majorbit")
@SpringBootApplication
public class DataBaseLaptopApplication{

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DataBaseLaptopApplication.class, args);
		
	}
	
	

}
