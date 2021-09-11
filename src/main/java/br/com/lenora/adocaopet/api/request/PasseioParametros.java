package br.com.lenora.adocaopet.api.request;

import lombok.Data;

@Data
public class PasseioParametros {
  private String bairro;
  private String cidade;
  private String estado;
  private String frequenciaDiaria;
  private String precoMensal;
}
