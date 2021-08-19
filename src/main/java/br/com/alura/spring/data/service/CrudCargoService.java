package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private final CargoRepository repository;
	
	private Boolean system = true;
	
	public CrudCargoService(CargoRepository repository) {
		this. repository=repository;
	}
	
	public void iniciar(Scanner scanner) {
		
		while(system) {
			System.out.println("Qual ação você quer executar?");
			System.out.println("0 - sair");
			System.out.println("1 - salvar");
			System.out.println("2 - atualizar");
			System.out.println("3 - visualizar");
			System.out.println("4 - excluir");
			int action = scanner.nextInt();
			switch (action) {
			case 1:
				this.salvar(scanner);
				break;
			case 2:
				this.atualizar(scanner);
				break;
			case 3:
				this.visualizar();
				break;
			case 4:
				this.deletar(scanner);
				break;
			default:
				this.system=false;
				break;
			}
		}
		this.salvar(scanner);
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Descrição do Cargo:");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		repository.save(cargo);
		
		System.out.println("Cargo Salvo");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("ID do Cargo:");
		Integer id= scanner.nextInt();
		System.out.println("Descrição do Cargo:");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargo.setId(id);
		
		repository.save(cargo);
		
		System.out.println("Cargo Atualizado");
	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = repository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("ID do Cargo a ser deletado:");
		Integer id= scanner.nextInt();
		repository.deleteById(id);
		System.out.println("Cargo deletado");
	}
}
