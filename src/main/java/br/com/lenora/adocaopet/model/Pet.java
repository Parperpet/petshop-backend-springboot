package br.com.lenora.adocaopet.model;

import javax.persistence.Column;
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
public class Pet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idPet;
  private String nome;
  private String idade;
	private String especie;
	private String cor;
  private String porte;
  private String olhos;
	private String custoMensal;
	private boolean necessitaPasseio;
	private boolean necessitaCompanhia;
  private String descricao;
  private boolean disponivelParaAdocao;

  @Column(columnDefinition = "text")
  private String fotoPerfilBase64;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idDono", referencedColumnName = "idUsuario")
  private Usuario dono;
}
