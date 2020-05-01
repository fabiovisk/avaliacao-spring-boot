package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.exception.EstudanteNotFoundException;
import br.com.tokiomarine.seguradora.avaliacao.exception.EstudanteResourceException;
import br.com.tokiomarine.seguradora.avaliacao.model.EstudanteResource;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;


@Service
public class EstudanteServiceImpl {
	
	private static final Logger LOG = Logger.getLogger(EstudanteServiceImpl.class);

	@Autowired
	private EstudanteRepository repository;
	
	@Autowired
	private EstudanteConversor estudanteConversor;

	public void cadastrarEstudante(EstudanteResource estudanteResource) {
		try {
			Estudante estudante = estudanteConversor.conversor(estudanteResource);
			repository.saveAndFlush(estudante);
		} catch (EstudanteResourceException e) {
			LOG.error("Erro ao salvar o Estudante: ", e.getMessage(), e);
		}
	}

	public List<Estudante> buscarEstudantes() {
		List<Estudante> listEstudantes = repository.findAll();
		return listEstudantes;
	}

	public Estudante buscarEstudante(Long id) throws EstudanteNotFoundException {
		Optional<Estudante> optionalEstudante = repository.findById(id);
		Estudante estudante = null;
		
		if (!optionalEstudante.isPresent()) {
			throw new EstudanteNotFoundException("Identificador inválido:" + id);
			
		} else {
			estudante = optionalEstudante.get();
		}
		return estudante;
	}
	
	private Optional<Estudante> getOptional(Long id) {
		Optional<Estudante> optionalEstudante = repository.findById(id);
		return optionalEstudante;
	}
	
	public void deleteEstudante(Long id) throws EstudanteNotFoundException {
		
		Optional<Estudante> optionalEstudante = getOptional(id);
		if (!optionalEstudante.isPresent()) {
			throw new EstudanteNotFoundException("Identificador inválido:" + id);
			
		} else {
			repository.delete(optionalEstudante.get());
		}
	}
	
	public Estudante saveEstudante(Estudante estudante) {
		return repository.saveAndFlush(estudante);
	}

    public void atualizarEstudante(
    		@PathVariable(value = "id") Long id, @Valid @RequestBody Estudante newEstudante) 
    		throws EstudanteNotFoundException {
    	
    	Optional<Estudante> optionalEstudante = getOptional(id);
    	
        if(!optionalEstudante.isPresent()){
        	throw new EstudanteNotFoundException("Estudante com este id: " + id + " não existe!"); 
         
        } else {
        	   Estudante estudante = optionalEstudante.get();
        	   
        	   estudante.setNome(newEstudante.getNome());
               estudante.setEmail(newEstudante.getEmail());
               estudante.setTelefone(newEstudante.getTelefone());
               estudante.setMatricula(newEstudante.getMatricula());
               estudante.setCurso(newEstudante.getCurso());
               
               repository.saveAndFlush(estudante);
        }
    }
}
