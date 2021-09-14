package br.com.lenora.adocaopet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lenora.adocaopet.model.ReservaHospedagem;

@Repository
public interface ReservaHospedagemRepository extends JpaRepository<ReservaHospedagem, Integer> {
  
}
