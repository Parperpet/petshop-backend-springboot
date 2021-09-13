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

import br.com.lenora.adocaopet.api.request.HospedagemParemetros;
import br.com.lenora.adocaopet.model.Hospedagem;
import br.com.lenora.adocaopet.service.hospedagem.HospedagemService;

@RestController
@RequestMapping("hospedagem")
@CrossOrigin
public class HospedagemController {
  @Autowired
  private HospedagemService service;

  @GetMapping(path = "retornaTodos")   
  public ResponseEntity<?> retornaTodos() {
    List<Hospedagem> hospedagem = service.retornaTodos();

    return new ResponseEntity<>(hospedagem, HttpStatus.OK);
  }

  @GetMapping(path = "retornaPorUsuario/{idUsuario}")   
  public ResponseEntity<?> retornaPorUsuario(@PathVariable Integer idUsuario) {
    List<Hospedagem> hospedagem = service.retornaPorUsuario(idUsuario);

    return new ResponseEntity<>(hospedagem, HttpStatus.OK);
  }

  @GetMapping(path = "retornaPorId/{idHospedagem}")   
  public ResponseEntity<?> retornaPorId(@PathVariable Integer idHospedagem) {
    Hospedagem hospedagem = service.retornaPorId(idHospedagem);

    return new ResponseEntity<>(hospedagem, HttpStatus.OK);
  }

  @PostMapping(path = "retornaComParametros")   
  public ResponseEntity<?> retornaComParametros(@RequestBody HospedagemParemetros request) {
    List<Hospedagem> hospedagem = service.retornaComParametros(request);

    return new ResponseEntity<>(hospedagem, HttpStatus.OK);
  }

  @PostMapping(path = "gravarHospedagem")
  @Transactional   
  public ResponseEntity<?> gravarHospedagem(@RequestBody Hospedagem request) {
    Hospedagem hospedagem = service.gravarHospedagem(request);

    return new ResponseEntity<>(hospedagem, HttpStatus.OK);
  }

  @PutMapping(path = "alterarHospedagem/{idHospedagem}")
  @Transactional  
  public ResponseEntity<?> alterarHospedagem(@RequestBody Hospedagem request, @PathVariable Integer idHospedagem) {    
    Hospedagem hospedagem = service.alterarHospedagem(idHospedagem, request);    

    return new ResponseEntity<>(hospedagem, HttpStatus.CREATED);
  }

  @DeleteMapping(path = "deletarHospedagem/{idHospedagem}")
  @Transactional  
  public ResponseEntity<?> deletarHospedagem(@PathVariable Integer idHospedagem) {
    service.deletarHospedagem(idHospedagem);

    return new ResponseEntity<>("Exclusão realizada com sucesso.", HttpStatus.OK);
  }
  
}
