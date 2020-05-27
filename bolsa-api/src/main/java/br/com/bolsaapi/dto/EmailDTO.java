package br.com.bolsaapi.dto;

public class EmailDTO {

	private String titulo;

	private String corpo;

	public EmailDTO() {}

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
