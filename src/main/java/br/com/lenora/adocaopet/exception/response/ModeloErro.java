package br.com.lenora.adocaopet.exception.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModeloErro {
  private Integer codigoErro;
  private String mensagem;
  private String erroOriginal;
}
