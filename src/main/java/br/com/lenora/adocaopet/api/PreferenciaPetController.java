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

import br.com.lenora.adocaopet.model.Pet;
import br.com.lenora.adocaopet.model.PreferenciaPet;
import br.com.lenora.adocaopet.service.preferenciaPet.PreferenciaPetService;

@RestController
@RequestMapping("preferenciaPet")
@CrossOrigin
public class PreferenciaPetController {
  @Autowired
  private PreferenciaPetService service;

  @GetMapping(path = "retornaMatchPorIdUsuario/{idUsuario}")   
  public ResponseEntity<?> retornaMatchPorIdUsuario(@PathVariable Integer idUsuario) {
    PreferenciaPet preferenciaPet = service.retornaMatchPorIdUsuario(idUsuario);

    return new ResponseEntity<>(preferenciaPet, HttpStatus.OK);
  }

  @PostMapping(path = "gravarPreferenciaPet")
  @Transactional  
  public ResponseEntity<?> gravarPreferenciaPet(@RequestBody PreferenciaPet request) {
    PreferenciaPet preferenciaPet = service.gravarPreferenciaPet(request);

    return new ResponseEntity<>(preferenciaPet, HttpStatus.CREATED);
  }

  @PostMapping(path = "retornaUsuariosCompativeisComPet")   
  public ResponseEntity<?> retornaUsuariosCompativeisComPet(@RequestBody Pet request) {
    List<PreferenciaPet> listaPreferenciaPet = service.retornaUsuariosCompativeisComPet(request);

    return new ResponseEntity<>(listaPreferenciaPet, HttpStatus.OK);
  }
  
}
