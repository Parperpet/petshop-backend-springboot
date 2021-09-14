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
public class ReservaPasseio {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idReservaPasseio;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idPasseio", referencedColumnName = "idPasseio")
  private Passeio passeio;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idCliente", referencedColumnName = "idUsuario")
  private Usuario cliente;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idPet", referencedColumnName = "idPet")
  private Pet pet;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idProfissional", referencedColumnName = "idUsuario")
  private Usuario profissional;

  private String tipoPagamento;
}
