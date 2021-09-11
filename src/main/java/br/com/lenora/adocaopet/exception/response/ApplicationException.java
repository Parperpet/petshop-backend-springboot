package br.com.lenora.adocaopet.exception.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.lenora.adocaopet.exception.ChatExistenteException;
import br.com.lenora.adocaopet.exception.ErroServidorException;
import br.com.lenora.adocaopet.exception.UsuarioExistenteException;
import br.com.lenora.adocaopet.exception.VazioException;

@ControllerAdvice
public class ApplicationException extends ResponseEntityExceptionHandler{

  @ExceptionHandler(VazioException.class)
  public ResponseEntity<ModeloErro> naoExisteException(VazioException e){
    ModeloErro modeloErro = new ModeloErro(HttpStatus.NOT_FOUND.value(), e.getMessage(), "");

    return new ResponseEntity<>(modeloErro, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ErroServidorException.class)
  public ResponseEntity<ModeloErro> erroServidorException(ErroServidorException e){
    ModeloErro modeloErro = new ModeloErro(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), e.getErroOriginal());

    return new ResponseEntity<>(modeloErro, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UsuarioExistenteException.class)
  public ResponseEntity<ModeloErro> usuarioExistenteException(UsuarioExistenteException e){
    ModeloErro modeloErro = new ModeloErro(HttpStatus.CONFLICT.value(), e.getMessage(), "");

    return new ResponseEntity<>(modeloErro, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(ChatExistenteException.class)
  public ResponseEntity<ModeloErro> chatExistenteException(ChatExistenteException e){
    ModeloErro modeloErro = new ModeloErro(HttpStatus.CONFLICT.value(), e.getMessage(), "");

    return new ResponseEntity<>(modeloErro, HttpStatus.CONFLICT);
  }

  
  
}
