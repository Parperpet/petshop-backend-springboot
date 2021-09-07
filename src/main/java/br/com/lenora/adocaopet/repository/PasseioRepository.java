package br.com.lenora.adocaopet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.lenora.adocaopet.model.Passeio;

@Repository
public interface PasseioRepository extends JpaRepository<Passeio, Integer> {
  @Query(value = "SELECT * FROM passeio WHERE id_profissional = :idUsuario", nativeQuery = true)
  List<Passeio> findByIdUsuario(@Param("idUsuario") Integer idUsuario);

  @Query(value = "SELECT * FROM passeio WHERE              " +
                 "bairro = :bairro OR                      " +
                 "cidade = :cidade OR                      " +
                 "estado = :estado OR                      " +
                 "frequencia_diaria = :frequenciaDiaria OR " +
                 "preco_mensal = :precoMensal              ", nativeQuery = true)
  List<Passeio> findByPasseiosPorParametro(@Param("bairro") String bairro, @Param("cidade") String cidade, @Param("estado") String estado, 
                                           @Param("frequenciaDiaria") String frequenciaDiaria, @Param("precoMensal") String precoMensal);
  
}
