package br.com.bolsaapi.dto;

import java.io.Serializable;

public class Papel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String nome;
	private String data;
	private String abertura;
	private String minimo;
	private String maximo;
	private String medio;
	private String ultimo;
	private String oscilacao;

	public Papel() {}

	public Papel( String codigo, String nome, String data, String abertura, String minimo, String maximo, String medio, String ultimo, String oscilacao ) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.data = data;
		this.abertura = abertura;
		this.minimo = minimo;
		this.maximo = maximo;
		this.medio = medio;
		this.ultimo = ultimo;
		this.oscilacao = oscilacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo( String codigo ) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData( String data ) {
		this.data = data;
	}

	public String getAbertura() {
		return abertura;
	}

	public void setAbertura( String abertura ) {
		this.abertura = abertura;
	}

	public String getMinimo() {
		return minimo;
	}

	public void setMinimo( String minimo ) {
		this.minimo = minimo;
	}

	public String getMaximo() {
		return maximo;
	}

	public void setMaximo( String maximo ) {
		this.maximo = maximo;
	}

	public String getMedio() {
		return medio;
	}

	public void setMedio( String medio ) {
		this.medio = medio;
	}

	public String getUltimo() {
		return ultimo;
	}

	public void setUltimo( String ultimo ) {
		this.ultimo = ultimo;
	}

	public String getOscilacao() {
		return oscilacao;
	}

	public void setOscilacao( String oscilacao ) {
		this.oscilacao = oscilacao;
	}

	@Override
	public String toString() {
		return "Papel [codigo=" + codigo + ", nome=" + nome + ", data=" + data + ", abertura=" + abertura + ", minimo=" + minimo + ", maximo=" + maximo + ", medio=" + medio + ", ultimo=" + ultimo + ", oscilacao=" + oscilacao + "]";
	}

}
