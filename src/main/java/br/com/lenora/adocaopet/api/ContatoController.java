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

import br.com.lenora.adocaopet.model.Contato;
import br.com.lenora.adocaopet.service.contato.ContatoService;

@RestController
@RequestMapping("contato")
@CrossOrigin
public class ContatoController {
  @Autowired
  ContatoService service;

  @GetMapping(path = "retornaTodos")   
  public ResponseEntity<?> retornaTodos() {
    List<Contato> listaContato = service.retornaTodos();

    return new ResponseEntity<>(listaContato, HttpStatus.OK);
  }

  @PostMapping(path = "gravarContato")
  @Transactional  
  public ResponseEntity<?> gravarContato(@RequestBody Contato request) {   
    Contato contato = service.gravarContato(request);

    return new ResponseEntity<>(contato, HttpStatus.CREATED);
  }

  @DeleteMapping(path = "excluirContato/{idMensagem}")
  @Transactional  
  public ResponseEntity<?> excluirContato(@PathVariable Integer idMensagem) {   
    service.excluirContato(idMensagem);

    return new ResponseEntity<>("Mensagem excluída com sucesso.", HttpStatus.CREATED);
  }
}
