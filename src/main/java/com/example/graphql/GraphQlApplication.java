package com.example.graphql;

import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}
	@Bean
	public ApplicationRunner applicationRunner(AuthorRepository authorRepository,
											   BookRepository bookRepository) {
		return args -> {
			authorRepository.save(new Author(null, "Venu"));
			authorRepository.save(new Author(null, "Gopal"));
			bookRepository.saveAll(List.of(
					new Book("SpringBoot Demo" , "AAA", new Author(null, "Venu")),
			new Book("SpringBoot cloud Demo" , "BBB", new Author(null, "Gopal")),
			new Book("SpringBoot mvc Demo" , "CCC", new Author(null, "Bathina"))
			));
		};

	}

}
