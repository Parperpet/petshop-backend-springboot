package br.com.lenora.adocaopet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lenora.adocaopet.model.ReservaPasseio;

@Repository
public interface ReservaPasseioRepository extends JpaRepository<ReservaPasseio, Integer>{
  @Query(value = "SELECT * FROM reserva_passeio WHERE id_cliente = :idUsuario", nativeQuery = true)
  List<ReservaPasseio> findByIdCliente(@Param("idUsuario") Integer idUsuario);

  @Query(value = "SELECT * FROM reserva_passeio WHERE id_profissional = :idUsuario", nativeQuery = true)
  List<ReservaPasseio> findByIdProfissional(Integer idUsuario);
  
}
