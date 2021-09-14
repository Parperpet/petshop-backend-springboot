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
public class Mensagem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idMensagem;
  private Integer idChat;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "remetente", referencedColumnName = "idUsuario")
  private Usuario remetente;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "destinatario", referencedColumnName = "idUsuario")
  private Usuario destinatario;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "pet", referencedColumnName = "idPet")
  private Pet pet;
  
  private String conteudo;
}
