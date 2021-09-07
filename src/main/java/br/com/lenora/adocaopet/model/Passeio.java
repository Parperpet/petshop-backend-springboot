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
public class Passeio {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idPasseio;
  private String bairro;
  private String cidade;
  private String estado;
  private String frequenciaDiaria;
  private String precoMensal;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idProfissional", referencedColumnName = "idUsuario")
  private Usuario usuario;
}
