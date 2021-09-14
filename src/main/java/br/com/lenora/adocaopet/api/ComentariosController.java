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

import br.com.lenora.adocaopet.api.response.ComentariosResponse;
import br.com.lenora.adocaopet.model.Comentarios;
import br.com.lenora.adocaopet.service.comentarios.ComentariosService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("comentarios")
@CrossOrigin
public class ComentariosController {
  @Autowired
  ComentariosService service;

  @GetMapping(path = "retornaPorUsuario/{idUsuario}")   
  public ResponseEntity<?> retornaPorUsuario(@PathVariable Integer idUsuario) {
    List<ComentariosResponse> listaComentariosResponse = service.retornaPorUsuario(idUsuario);

    return new ResponseEntity<>(listaComentariosResponse, HttpStatus.OK);
  }

  @GetMapping(path = "retornaAprovados/{idUsuario}")   
  public ResponseEntity<?> retornaAprovados(@PathVariable Integer idUsuario) {
    List<ComentariosResponse> listaComentariosResponse = service.retornaAprovados(idUsuario);

    return new ResponseEntity<>(listaComentariosResponse, HttpStatus.OK);
  }

  @PostMapping(path = "gravarComentario")
  @Transactional  
  public ResponseEntity<?> gravarComentario(@RequestBody Comentarios request) {
    Comentarios comentarios = service.gravarComentario(request);

    return new ResponseEntity<>(comentarios, HttpStatus.CREATED);
  }

  @PutMapping(value="aprovarComentario/{idComentario}")
  @Transactional
  public ResponseEntity<?> aprovarComentario(@PathVariable Integer idComentario, @RequestBody Comentarios request) {
    Comentarios comentarios = service.aprovarComentario(request);
      
    return new ResponseEntity<>(comentarios, HttpStatus.OK);
  }

  @DeleteMapping(value="deletarComentario/{idComentario}")
  @Transactional
  public ResponseEntity<?> deletarComentario(@PathVariable Integer idComentario) {
    service.deletarComentario(idComentario);
      
    return new ResponseEntity<>("Comentário excluido com sucesso.", HttpStatus.OK);
  }
}
