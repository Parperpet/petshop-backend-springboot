package br.com.lenora.adocaopet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lenora.adocaopet.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
  List<Pet> findByDisponivelParaAdocaoIsTrue();

  @Query(value = "select * from pet where id_dono = :id_dono", nativeQuery = true)
  List<Pet> findByIdDono(@Param ("id_dono") Integer idDono);

  @Query(value = "SELECT * FROM pet                " +
                 "WHERE idade = :idade             " +
                 "AND especie = :especie           " +
                 "AND cor = :cor                   " +
                 "AND olhos = :olhos               " +
                 "AND porte = :porte               " +
                 "AND custo_mensal = :custo_mensal " +
                 "AND sexo = :sexo                 " +
                 "AND id_dono != :idUsuario     ", nativeQuery = true)
  List<Pet> buscaMatchComParametros(@Param("idade") String idade, @Param("especie") String especie, @Param("cor") String cor, 
                                    @Param("porte") String porte, @Param("olhos") String olhos, @Param("custo_mensal") String custoMensal,
                                    @Param("idUsuario") Integer idUsuario, @Param("sexo") String sexo);   
}
