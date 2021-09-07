package br.com.lenora.adocaopet.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class PreferenciaPet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idPreferenciaPet;
  private String idade;
	private String especie;
	private String cor;
  private String porte;
  private String olhos;
	private String custoMensal;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
  private Usuario usuario;
}
