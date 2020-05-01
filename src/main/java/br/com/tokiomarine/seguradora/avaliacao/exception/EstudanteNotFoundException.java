package br.com.tokiomarine.seguradora.avaliacao.exception;

@SuppressWarnings("serial")
public class EstudanteNotFoundException extends Exception {

	public EstudanteNotFoundException() {
		super();
	}

	public EstudanteNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EstudanteNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EstudanteNotFoundException(String message) {
		super(message);
	}

	public EstudanteNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
