package br.com.lenora.adocaopet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lenora.adocaopet.model.Comentarios;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Integer>{

  List<Comentarios> findByIdProfissional(Integer idUsuario);
  
}
