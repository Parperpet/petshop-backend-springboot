package br.com.lenora.adocaopet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lenora.adocaopet.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
  Optional<Usuario> findByEmailAndSenha(String email, String senha);

  Optional<Usuario> findByEmail(String email);

  List<Usuario> findByNivelAcesso(String string);
}
