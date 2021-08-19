package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.CrudCargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{

	private final CrudCargoService service;
	
	private Boolean system = true;
	
	public SpringDataApplication(CrudCargoService service) {
		this.service = service;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		while(system) {
			System.out.println("Qual ação você quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			
			int action = sc.nextInt();
			
			if(action == 1) {
				service.iniciar(sc);
			}
			else {
				system = false;
			}
		}

	}

}
