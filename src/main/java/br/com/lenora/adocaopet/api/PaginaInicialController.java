package br.com.lenora.adocaopet.api;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lenora.adocaopet.api.response.PaginaInicialResponse;
import br.com.lenora.adocaopet.model.PaginaInicial;
import br.com.lenora.adocaopet.service.paginaInicial.PaginaInicialService;

@RestController
@RequestMapping("pagina-inicial")
@CrossOrigin
public class PaginaInicialController {
  @Autowired
  PaginaInicialService service;

  @GetMapping(path = "retornaPaginaInicial")   
  public ResponseEntity<?> retornaPaginaInicial() {
    PaginaInicialResponse paginaInicial = service.retornaPaginaInicial();

    return new ResponseEntity<>(paginaInicial, HttpStatus.OK);
  }

  @PostMapping(path = "gravarPaginaInicial")
  @Transactional   
  public ResponseEntity<?> gravarPaginaInicial(@RequestBody PaginaInicial request) {
    PaginaInicial paginaInicial = service.gravarPaginaInicial(request);

    return new ResponseEntity<>(paginaInicial, HttpStatus.OK);
  }
}
