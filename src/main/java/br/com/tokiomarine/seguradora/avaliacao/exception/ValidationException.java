package br.com.tokiomarine.seguradora.avaliacao.exception;

@SuppressWarnings("serial")
public class ValidationException extends Exception{
	
	public ValidationException(String message) {
		super(message);
	}
}