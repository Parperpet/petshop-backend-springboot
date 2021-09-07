package br.com.lenora.adocaopet.exception;

public class UsuarioExistenteException extends RuntimeException {
  
  public UsuarioExistenteException(String email){
    super("Já existe um usuario cadastrado com o email " + email +  ".");
  }
}
