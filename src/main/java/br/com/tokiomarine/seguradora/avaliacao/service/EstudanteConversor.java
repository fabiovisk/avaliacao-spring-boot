package br.com.tokiomarine.seguradora.avaliacao.service;

import org.springframework.stereotype.Component;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.exception.EstudanteResourceException;
import br.com.tokiomarine.seguradora.avaliacao.model.EstudanteResource;

@Component
public class EstudanteConversor {

	public Estudante conversor(EstudanteResource estudanteResource) throws EstudanteResourceException {
		
		try {
			Estudante estudante = new Estudante();
			Long matricula = checkMatricula(estudanteResource.getMatricula());
			
			estudante.setMatricula(matricula);
			estudante.setNome(estudanteResource.getNome());
			estudante.setCurso(estudanteResource.getCurso());
			estudante.setTelefone(estudanteResource.getTelefone());
			estudante.setEmail(estudanteResource.getEmail());
			
			return estudante;
			
		} catch (Exception e) {
			throw new EstudanteResourceException("Falha ao converter o resource para entidade, resource: " 
					+ estudanteResource );
		}
	}
	
	private Long checkMatricula(String matricula) {
		return Long.parseLong(matricula);
	}
}
