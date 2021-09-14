package br.com.lenora.adocaopet.api.request;

import lombok.Data;

@Data
public class HospedagemParemetros {
  private String cidade;
  private String tipo;
  private String especieAceita;
  private String porteAceito;
  private String precoDiaria;
}
