package br.com.lenora.adocaopet.model;

import java.time.LocalDate;

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
public class ReservaHospedagem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idReservaHospedagem;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
  private Usuario usuario;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idPet", referencedColumnName = "idPet")
  private Pet pet;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idHospedagem", referencedColumnName = "idHospedagem")
  private Hospedagem hospedagem;

  private String tipoPagamento;
  private LocalDate dataEntrada;
  private LocalDate dataSaida;
  
  
}
