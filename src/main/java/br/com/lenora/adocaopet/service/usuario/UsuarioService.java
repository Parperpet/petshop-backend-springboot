package br.com.lenora.adocaopet.service.usuario;

import java.util.List;

import br.com.lenora.adocaopet.api.request.Login;
import br.com.lenora.adocaopet.model.Usuario;

public interface UsuarioService {

  List<Usuario> retornaTodos();

  Usuario retornaPorId(Integer idUsuario);

  Usuario gravarUsuario(Usuario request);

  Usuario alterarUsuario(Integer idUsuario, Usuario request);

  void deletarUsuario(Integer idUsuario);

  Usuario login(Login request);

  Boolean existeEmailCadastrado(String email);

  List<Usuario> retornaProfissionais();

  Usuario avaliarProfissional(Integer idUsuario, Usuario request);
  
}
