package br.com.lenora.adocaopet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Contato {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idMensagem;
  private String nome;
  private String email;
  private String mensagem;
  private boolean cliente;
}
