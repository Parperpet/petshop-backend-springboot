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
public class Hospedagem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idHospedagem;
  private String nome;
  private String endereco;
  private String bairro;
  private String cidade;
  private String estado;
  private String tipo;
  private String especieAceita;
  private String porteAceito;
  private String precoDiaria;
  private String descricao;
  
  @Column(columnDefinition = "text")
  private String fotoPerfilBase64;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
  private Usuario idUsuario;
   
}
