package com.aluradesafio2.literalura;

import com.aluradesafio2.literalura.principal.Principal;
import com.aluradesafio2.literalura.repository.AutorRepository;
import com.aluradesafio2.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private LibroRepository repositoryL;
	@Autowired
	private AutorRepository repositoryA;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositoryL,repositoryA);
		principal.runApplication();
	}
}
