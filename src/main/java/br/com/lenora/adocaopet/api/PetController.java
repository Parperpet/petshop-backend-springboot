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

import br.com.lenora.adocaopet.model.Pet;
import br.com.lenora.adocaopet.model.PreferenciaPet;
import br.com.lenora.adocaopet.service.pet.PetService;

@RestController
@RequestMapping("pet")
@CrossOrigin
public class PetController {
  @Autowired
  private PetService service;

  @GetMapping(path = "retornaTodos")   
  public ResponseEntity<?> retornaTodos() {
    List<Pet> listaPet = service.retornaTodos();

    return new ResponseEntity<>(listaPet, HttpStatus.OK);
  }

  @GetMapping(path = "retornaPetsDisponiveisParaAdocao")   
  public ResponseEntity<?> retornaPetsDisponiveisParaAdocao() {
    List<Pet> listaPet = service.retornaPetsDisponiveisParaAdocao();

    return new ResponseEntity<>(listaPet, HttpStatus.OK);
  }

  @PostMapping(path = "retornaPetsCompativeisComPerfil/")   
  public ResponseEntity<?> retornaPetsCompativeisComPerfil(@RequestBody PreferenciaPet request) {
    List<Pet> listaPet = service.retornaPetsCompativeisComPerfil(request);

    return new ResponseEntity<>(listaPet, HttpStatus.OK);
  }

  @GetMapping(path = "retornaPorId/{idPet}")   
  public ResponseEntity<?> retornaPorId(@PathVariable Integer idPet) {
    Pet pet = service.retornaPorId(idPet);

    return new ResponseEntity<>(pet, HttpStatus.OK);
  }

  @GetMapping(path = "retornaMeusPets/{idUsuario}")   
  public ResponseEntity<?> retornaMeusPets(@PathVariable Integer idUsuario) {
    List<Pet> listaPet = service.retornaMeusPets(idUsuario);

    return new ResponseEntity<>(listaPet, HttpStatus.OK);
  }

  @PostMapping(path = "gravarPet")
  @Transactional  
  public ResponseEntity<?> gravarPet(@RequestBody Pet request) {
    Pet pet = service.gravarPet(request);

    return new ResponseEntity<>(pet, HttpStatus.CREATED);
  }

  @PutMapping(path = "alterarPet/{idPet}")
  @Transactional  
  public ResponseEntity<?> alterarPet(@RequestBody Pet request, @PathVariable Integer idPet) {    
    Pet pet = service.alterarPet(idPet, request);    

    return new ResponseEntity<>(pet, HttpStatus.CREATED);
  }

  @DeleteMapping(path = "deletarPet/{idPet}")
  @Transactional  
  public ResponseEntity<?> deletarPet(@PathVariable Integer idPet) {
    service.deletarPet(idPet);

    return new ResponseEntity<>("Exclusão realizada com sucesso.", HttpStatus.OK);
  }


  
}
