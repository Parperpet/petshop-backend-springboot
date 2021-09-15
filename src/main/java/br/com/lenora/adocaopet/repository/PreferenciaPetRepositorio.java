package br.com.lenora.adocaopet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lenora.adocaopet.model.PreferenciaPet;

@Repository
public interface PreferenciaPetRepositorio extends JpaRepository<PreferenciaPet, Integer> { 
  @Query(value = "SELECT * FROM preferencia_pet " +
                 "WHERE id_usuario = :idUsuario", nativeQuery = true)                                        
  Optional<PreferenciaPet> findByIdUsuario(@Param("idUsuario") Integer idUsuario);

  List<PreferenciaPet> findByCorAndCustoMensalAndEspecieAndIdadeAndOlhosAndPorteAndSexo(String cor, String custoMensal, String especie, 
                                                                                 String idade, String olhos, String porte, String sexo);
}
