package br.com.lenora.adocaopet.service.usuario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lenora.adocaopet.api.request.Login;
import br.com.lenora.adocaopet.exception.ErroServidorException;
import br.com.lenora.adocaopet.exception.VazioException;
import br.com.lenora.adocaopet.model.Usuario;
import br.com.lenora.adocaopet.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
  @Autowired
  private UsuarioRepository repository;

  @Override
  public List<Usuario> retornaTodos() {
    List<Usuario> listaUsuario = new ArrayList<>();
    try {
      listaUsuario = repository.findAll();

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaUsuario.size() > 0) {
      return listaUsuario;
    }

    throw new VazioException("Não foi encontrado nenhum Usuario");
  }

  @Override
  public Usuario retornaPorId(Integer idUsuario) {
    Optional<Usuario> Usuario;    
    try {
      Usuario = repository.findById(idUsuario);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (Usuario.isPresent()) {
      return Usuario.get();
    }

    throw new VazioException("Não foi encontrado nenhum Usuario com o id " + idUsuario);
  }

  @Override
  public Usuario login(Login request) {
    Optional<Usuario> Usuario;    
    try {
      Usuario = repository.findByEmailAndSenha(request.getEmail(), request.getSenha());

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (Usuario.isPresent()) {
      return Usuario.get();
    }

    throw new VazioException("Login ou senha incorreto.");  
  }

  @Override
  public Usuario gravarUsuario(Usuario request) {
    try {
      return repository.save(request);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }
  }

  @Override
  public Usuario alterarUsuario(Integer idUsuario, Usuario request) {
    retornaPorId(idUsuario);
    request.setIdUsuario(idUsuario);

    return gravarUsuario(request);
  }

  @Override
  public void deletarUsuario(Integer idUsuario) {
    retornaPorId(idUsuario);

    repository.deleteById(idUsuario);        
  }

  @Override
  public Boolean existeEmailCadastrado(String email) {
    Optional<Usuario> Usuario; 

    try {
      Usuario = repository.findByEmail(email);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    return Usuario.isPresent();

  }

  @Override
  public List<Usuario> retornaProfissionais() {
    List<Usuario> listaUsuario = new ArrayList<>();

    try {
      listaUsuario = repository.findByNivelAcesso("Profissional");

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaUsuario.size() > 0) {
      return listaUsuario;
    }

    throw new VazioException("Não foi encontrado nenhum Usuario");
  }

  @Override
  public Usuario avaliarProfissional(Integer idUsuario, Usuario request) {
    Usuario usuario = retornaPorId(idUsuario);

    if (usuario.getQtdNotasRecebidas() == null) {
      request.setQtdNotasRecebidas(1);

    } else {
      request.setQtdNotasRecebidas(usuario.getQtdNotasRecebidas() + 1);
    }

    if (usuario.getNotaProfissional() == null) {
      request.setNotaProfissional(request.getNotaProfissional());  

    } else {
      request.setNotaProfissional((usuario.getNotaProfissional().add(request.getNotaProfissional())
                                                              .divide(BigDecimal.valueOf(request.getQtdNotasRecebidas()))));
    } 
    
    return gravarUsuario(request);
  }

  
  
}
