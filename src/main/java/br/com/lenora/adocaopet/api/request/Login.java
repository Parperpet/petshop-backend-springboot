package br.com.lenora.adocaopet.api.request;

import lombok.Data;

@Data
public class Login {
  private String email;
  private String senha;
}
