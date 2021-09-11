package br.com.lenora.adocaopet.exception;

public class ErroServidorException extends RuntimeException {
  private String erro;
  
  public ErroServidorException(String erro){    
    super("Estamos sofrendo uma instabilidade nos nossos servidores. Tente novamente mais tarde.");
    this.erro = erro;
  }

  public String getErroOriginal(){
    return erro;
  }
}
