package br.com.lenora.adocaopet.exception;

public class ChatExistenteException extends RuntimeException {

  public ChatExistenteException(){
    super("Já existe um chat em aberto para este pet. Acesse sua caixa de entrada");
  }
  
}
