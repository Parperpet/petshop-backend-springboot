package br.com.lenora.adocaopet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Comentarios {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idComentario;
  private Integer idProfissional;
  private Integer idCliente;
  private String comentario;
  private boolean aprovadoAdm;
}
