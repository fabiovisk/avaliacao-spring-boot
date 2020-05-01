package br.com.tokiomarine.seguradora.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.exception.EstudanteNotFoundException;
import br.com.tokiomarine.seguradora.avaliacao.model.EstudanteResource;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteServiceImpl;

@RestController
@RequestMapping("/estudantes")
public class EstudanteRestController {
	
	@Autowired
	private EstudanteServiceImpl service;

	@GetMapping(path = "/listar")
	public List<Estudante> buscarEstudantes(){ 
		return service.buscarEstudantes();
	}
	
	@GetMapping(path = "/buscar/id/{id}")
	public Estudante buscarEstudantePorId(
			@PathVariable(name = "id", required = true) Long id) 
			throws EstudanteNotFoundException{ 
		return service.buscarEstudante(id);
	}
	
	@PostMapping(path = "/salvar")
	public void salvarEstudante(@RequestBody Estudante estudante){ 
		service.saveEstudante(estudante);
	}
	
	@PostMapping(path = "/cadastrar")
	public void cadastrarEstudante(@RequestBody EstudanteResource estudanteResource){ 
		service.cadastrarEstudante(estudanteResource);
	}
	
	@DeleteMapping(path = "/deletar/id/{id}")
	public void deletarEstudante(
			@PathVariable(name = "id", required = true) Long id) 
			throws EstudanteNotFoundException {
		service.deleteEstudante(id);
	}

	@PutMapping(path = "/editar/id/{id}")
	public void exibirEdicaoEstudante(
			@PathVariable(name = "id", required = true) Long id, 
			@RequestBody Estudante estudante) throws EstudanteNotFoundException {
		service.atualizarEstudante(id, estudante);
	}

}
