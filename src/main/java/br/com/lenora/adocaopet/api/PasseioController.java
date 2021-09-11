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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lenora.adocaopet.api.request.PasseioParametros;
import br.com.lenora.adocaopet.model.Passeio;
import br.com.lenora.adocaopet.service.passeio.PasseioService;


@RestController
@RequestMapping("passeio")
@CrossOrigin
public class PasseioController {
  @Autowired
  PasseioService service;
  
  @GetMapping(path = "retornaPorUsuario/{idUsuario}")   
  public ResponseEntity<?> retornaPorUsuario(@PathVariable Integer idUsuario) {
    List<Passeio> passeio = service.retornaPorUsuario(idUsuario);

    return new ResponseEntity<>(passeio, HttpStatus.OK);
  }
  
  @GetMapping(path = "retornaPorid/{idPasseio}")   
  public ResponseEntity<?> retornaPorid(@PathVariable Integer idPasseio) {
    Passeio passeio = service.retornaPorid(idPasseio);

    return new ResponseEntity<>(passeio, HttpStatus.OK);
  }

  @PostMapping(path = "retornaComParametros")
  @Transactional   
  public ResponseEntity<?> retornaComParametros(@RequestBody PasseioParametros request) {
    List<Passeio> passeio = service.retornaComParametros(request);

    return new ResponseEntity<>(passeio, HttpStatus.OK);
  }

  @PostMapping(path = "gravarPasseio")
  @Transactional   
  public ResponseEntity<?> gravarPasseio(@RequestBody Passeio request) {
    Passeio passeio = service.gravarPasseio(request);

    return new ResponseEntity<>(passeio, HttpStatus.OK);
  }

  @PutMapping(path = "alterarPasseio/{idPasseio}")
  @Transactional  
  public ResponseEntity<?> alterarPasseio(@RequestBody Passeio request, @PathVariable Integer idPasseio) {    
    Passeio passeio = service.alterarPasseio(idPasseio, request);    

    return new ResponseEntity<>(passeio, HttpStatus.CREATED);
  }

  @DeleteMapping(path = "deletarPasseio/{idPasseio}")
  @Transactional  
  public ResponseEntity<?> deletarPasseio(@PathVariable Integer idPasseio) {
    service.deletarPasseio(idPasseio);

    return new ResponseEntity<>("Exclusão realizada com sucesso.", HttpStatus.OK);
  }
  
  
}
