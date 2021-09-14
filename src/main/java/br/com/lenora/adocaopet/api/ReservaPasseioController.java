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
import br.com.lenora.adocaopet.model.ReservaPasseio;
import br.com.lenora.adocaopet.service.reservaPasseio.ReservaPasseioService;

@RestController
@RequestMapping("reserva-passeio")
@CrossOrigin
public class ReservaPasseioController {
  @Autowired
  ReservaPasseioService service;

  @GetMapping(path = "retornaPorCliente/{idUsuario}")   
  public ResponseEntity<?> retornaPorCliente(@PathVariable Integer idUsuario) {
    List<ReservaPasseio> listaReservaPasseio = service.retornaPorCliente(idUsuario);

    return new ResponseEntity<>(listaReservaPasseio, HttpStatus.OK);
  }

  @GetMapping(path = "retornaPorProfissional/{idUsuario}")   
  public ResponseEntity<?> retornaPorProfissional(@PathVariable Integer idUsuario) {
    List<ReservaPasseio> listaReservaPasseio = service.retornaPorProfissional(idUsuario);

    return new ResponseEntity<>(listaReservaPasseio, HttpStatus.OK);
  }

  @PostMapping(path = "gravarReservaPasseio")
  @Transactional   
  public ResponseEntity<?> gravarReservaPasseio(@RequestBody ReservaPasseio request) {
    ReservaPasseio reservaPasseio = service.gravarReservaPasseio(request);

    return new ResponseEntity<>(reservaPasseio, HttpStatus.OK);
  }

  @DeleteMapping(path = "deletarReservaPasseio/{idReservaPasseio}")
  @Transactional  
  public ResponseEntity<?> deletarReservaPasseio(@PathVariable Integer idReservaPasseio) {
    service.deletarReservaPasseio(idReservaPasseio);

    return new ResponseEntity<>("Exclusão realizada com sucesso.", HttpStatus.OK);
  }
}
