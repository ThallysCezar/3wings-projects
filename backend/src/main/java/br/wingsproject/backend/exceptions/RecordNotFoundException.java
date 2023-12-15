package br.wingsproject.backend.exceptions;

public class RecordNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public RecordNotFoundException(Long id) {
		super(String.format("Registro nao encontrado com o id: %s", id));
	}
}
