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

import br.com.lenora.adocaopet.api.request.Login;
import br.com.lenora.adocaopet.exception.UsuarioExistenteException;
import br.com.lenora.adocaopet.model.Usuario;
import br.com.lenora.adocaopet.service.usuario.UsuarioService;

@RestController
@RequestMapping("usuario")
@CrossOrigin()
public class UsuarioController {
  @Autowired
  private UsuarioService service;

  @GetMapping(path = "retornaTodos")   
  public ResponseEntity<?> retornaTodos() {
    List<Usuario> listaUsuario = service.retornaTodos();

    return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
  }

  @GetMapping(path = "retornaProfissionais")   
  public ResponseEntity<?> retornaProfissionais() {
    List<Usuario> listaUsuario = service.retornaProfissionais();

    return new ResponseEntity<>(listaUsuario, HttpStatus.OK);
  }
  

  @GetMapping(path = "retornaPorId/{idUsuario}")   
  public ResponseEntity<?> retornaPorId(@PathVariable Integer idUsuario) {
    Usuario usuario = service.retornaPorId(idUsuario);    

    return new ResponseEntity<>(usuario, HttpStatus.OK);
  }

  @PostMapping(path = "login")   
  public ResponseEntity<?> login(@RequestBody Login request) {
    Usuario usuario = service.login(request);

    return new ResponseEntity<>(usuario, HttpStatus.OK);
  }

  @PostMapping(path = "gravarUsuario")
  @Transactional  
  public ResponseEntity<?> gravarUsuario(@RequestBody Usuario request) {
    if (service.existeEmailCadastrado(request.getEmail())) {
      throw new UsuarioExistenteException(request.getEmail());
    }
    
    Usuario usuario = service.gravarUsuario(request);

    return new ResponseEntity<>(usuario, HttpStatus.CREATED);
  }

  @PutMapping(path = "alterarUsuario/{idUsuario}")
  @Transactional  
  public ResponseEntity<?> alterarUsuario(@RequestBody Usuario request, @PathVariable Integer idUsuario) {    
    Usuario usuario = service.alterarUsuario(idUsuario, request);    

    return new ResponseEntity<>(usuario, HttpStatus.CREATED);
  }

  @PutMapping(path = "avaliarProfissional/{idUsuario}")
  @Transactional  
  public ResponseEntity<?> avaliarProfissional(@RequestBody Usuario request, @PathVariable Integer idUsuario) {    
    Usuario usuario = service.avaliarProfissional(idUsuario, request);    

    return new ResponseEntity<>(usuario, HttpStatus.CREATED);
  }

  @DeleteMapping(path = "deletarUsuario/{idUsuario}")
  @Transactional  
  public ResponseEntity<?> deletarUsuario(@PathVariable Integer idUsuario) {
    service.deletarUsuario(idUsuario);

    return new ResponseEntity<>("Exclusão realizada com sucesso.", HttpStatus.OK);
  }
}
