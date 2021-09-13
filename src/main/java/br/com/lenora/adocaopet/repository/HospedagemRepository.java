package br.com.lenora.adocaopet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lenora.adocaopet.model.Hospedagem;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem, Integer> {
  @Query(value = "SELECT * FROM hospedagem           " +
                 "WHERE cidade = :cidade OR          " +
                 "tipo = :tipo OR                    " +
                 "especie_aceita = :especieAceita OR " +
                 "porte_aceito = :porteAceito OR     " +
                 "preco_diaria = :precoDiaria        ", nativeQuery = true)
  List<Hospedagem> findByComParametros(@Param("cidade") String cidade, @Param("tipo") String tipo, @Param("especieAceita") String especieAceita,
                                      @Param("porteAceito") String porteAceito, @Param("precoDiaria") String precoDiaria);

  @Query(value = "SELECT * FROM hospedagem WHERE id_usuario = :idUsuario", nativeQuery = true)
  List<Hospedagem> findByIdUsuario(@Param("idUsuario") Integer idUsuario);
  
}