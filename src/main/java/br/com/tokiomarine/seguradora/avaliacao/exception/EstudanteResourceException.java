package br.com.tokiomarine.seguradora.avaliacao.exception;

@SuppressWarnings("serial")
public class EstudanteResourceException extends Exception {

	public EstudanteResourceException() {
		super();
	}

	public EstudanteResourceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EstudanteResourceException(String message, Throwable cause) {
		super(message, cause);
	}

	public EstudanteResourceException(String message) {
		super(message);
	}

	public EstudanteResourceException(Throwable cause) {
		super(cause);
	}
	

}
