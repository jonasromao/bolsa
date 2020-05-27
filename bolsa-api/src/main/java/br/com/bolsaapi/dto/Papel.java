package br.com.bolsaapi.dto;

import java.io.Serializable;

public class Papel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String nome;
	private String data;
	private Double abertura;
	private Double minimo;
	private Double maximo;
	private Double medio;
	private Double ultimo;
	private Double oscilacao;

	public Papel() {}

	public Papel( String codigo, String nome, String data, Double abertura, Double minimo, Double maximo, Double medio, Double ultimo, Double oscilacao ) {
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

	public Double getAbertura() {
		return abertura;
	}

	public void setAbertura( Double abertura ) {
		this.abertura = abertura;
	}

	public Double getMinimo() {
		return minimo;
	}

	public void setMinimo( Double minimo ) {
		this.minimo = minimo;
	}

	public Double getMaximo() {
		return maximo;
	}

	public void setMaximo( Double maximo ) {
		this.maximo = maximo;
	}

	public Double getMedio() {
		return medio;
	}

	public void setMedio( Double medio ) {
		this.medio = medio;
	}

	public Double getUltimo() {
		return ultimo;
	}

	public void setUltimo( Double ultimo ) {
		this.ultimo = ultimo;
	}

	public Double getOscilacao() {
		return oscilacao;
	}

	public void setOscilacao( Double oscilacao ) {
		this.oscilacao = oscilacao;
	}

	@Override
	public String toString() {
		return "Papel [codigo=" + codigo + ", nome=" + nome + ", data=" + data + ", abertura=" + abertura + ", minimo=" + minimo + ", maximo=" + maximo + ", medio=" + medio + ", ultimo=" + ultimo + ", oscilacao=" + oscilacao + "]";
	}

}
