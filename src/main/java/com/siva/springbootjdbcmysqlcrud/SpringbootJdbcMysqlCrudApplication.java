package com.siva.springbootjdbcmysqlcrud;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootJdbcMysqlCrudApplication {

	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJdbcMysqlCrudApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runne(final MovieJDBCRepository repo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Movie bahubali_1 = new Movie("Bahubali_1", "Rajamouli", new Date(2018, 01, 01));
				Movie bahubali_2 = new Movie("Bahubali_2", "Rajamouli", new Date(2020, 01, 01));
				// INSERT
				repo.insert(bahubali_1);
				repo.insert(bahubali_2);
				// FIND ALL
				System.out.println("FIND ALL::: "+repo.findAll());
				
				// FIND BY ID
				System.out.println("FIND BY ID 1::: "+repo.findById(1));
				bahubali_2.setReleaseDate(new Date(2020, 12, 12));
				// UPDATE 
				repo.updateMovie(bahubali_2, 2);
				System.out.println("FIND BY ID 2::: "+repo.findById(2));
				// DELETE
				repo.deleteByid(1);
				System.out.println("FIND ALL::: "+repo.findAll());
			}
		};
	}

}
