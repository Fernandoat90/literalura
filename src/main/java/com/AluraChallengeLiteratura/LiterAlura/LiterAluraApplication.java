package com.AluraChallengeLiteratura.LiterAlura;

import com.AluraChallengeLiteratura.LiterAlura.principal.MenuConsola;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	private final MenuConsola menu;

	public LiterAluraApplication(MenuConsola menu){
		this.menu=menu;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		menu.iniciar();
	}
}
