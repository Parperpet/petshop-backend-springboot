package br.com.lenora.adocaopet.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lenora.adocaopet.model.Mensagem;
import br.com.lenora.adocaopet.service.mensagem.MensagemService;

@RestController
@RequestMapping("mensagem")
@CrossOrigin
public class MensagemController {
  @Autowired
  private MensagemService service;

  @GetMapping(path = "retornaHistoricoConversa/{idUsuario}")   
  public ResponseEntity<?> retornaHistoricoConversa(@PathVariable Integer idUsuario) {
    List<Mensagem> conversa = service.retornaHistoricoConversa(idUsuario);

    return new ResponseEntity<>(conversa, HttpStatus.OK);
  }

  @PostMapping(path = "gravarMensagem")
  @Transactional  
  public ResponseEntity<?> gravarMensagem(@RequestBody Mensagem request) {
    service.verificaExistenciaChat(request);

    Mensagem mensagem = service.gravarMensagem(request);

    return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
  }

  @PostMapping(path = "gravarNovaMensagem")
  @Transactional  
  public ResponseEntity<?> gravarNovaMensagem(@RequestBody Mensagem request) { 
    Mensagem mensagem = service.gravarNovaMensagem(request);

    return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
  }

  @PostMapping(path = "gravarContatoAdm")
  @Transactional  
  public ResponseEntity<?> gravarContatoAdm(@RequestBody Mensagem request) { 
    Mensagem mensagem = service.gravarMensagem(request);

    return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
  }

  @DeleteMapping(path = "excluirChat/{idChat}")
  @Transactional  
  public ResponseEntity<?> excluirChat(@PathVariable Integer idChat) { 
    service.excluirChat(idChat);

    return new ResponseEntity<>("Chat excluído com sucesso.", HttpStatus.CREATED);
  }


}
