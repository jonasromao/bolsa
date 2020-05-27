package br.com.bolsaapi.dto;

public class Email {

	private String titulo;

	private String corpo;

	public Email() {}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo( String titulo ) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo( String corpo ) {
		this.corpo = corpo;
	}

}
