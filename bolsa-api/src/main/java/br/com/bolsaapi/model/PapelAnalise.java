package br.com.bolsaapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PapelAnalise implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@OneToOne
	@JoinColumn( name = "idPapel", nullable = false )
	private Papel papel;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idUsuario", nullable = false )
	private Usuario usuario;
	
	private Double minimo;
	
	private Double maximo;
	
}
