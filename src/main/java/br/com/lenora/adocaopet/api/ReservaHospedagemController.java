package br.com.lenora.adocaopet.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lenora.adocaopet.model.ReservaHospedagem;
import br.com.lenora.adocaopet.service.reservaHospedagem.ReservaHospedagemService;

@RestController
@RequestMapping("reserva-hospedagem")
@CrossOrigin
public class ReservaHospedagemController {
  @Autowired
  private ReservaHospedagemService service;

  @GetMapping(path = "retornaTodos")   
  public ResponseEntity<?> retornaTodos() {
    List<ReservaHospedagem> listaReservaHospedagem = service.retornaTodos();

    return new ResponseEntity<>(listaReservaHospedagem, HttpStatus.OK);
  }  

  @GetMapping(path = "retornaPorId/{idReservaHospedagem}")   
  public ResponseEntity<?> retornaPorId(@PathVariable Integer idReservaHospedagem) {
    ReservaHospedagem reservaHospedagem = service.retornaPorId(idReservaHospedagem);    

    return new ResponseEntity<>(reservaHospedagem, HttpStatus.OK);
  }

  @PostMapping(path = "gravarReservaHospedagem")
  @Transactional  
  public ResponseEntity<?> gravarReservaHospedagem(@RequestBody ReservaHospedagem request) {
    ReservaHospedagem reservaHospedagem = service.gravarReservaHospedagem(request);

    return new ResponseEntity<>(reservaHospedagem, HttpStatus.CREATED);
  }
  
}
