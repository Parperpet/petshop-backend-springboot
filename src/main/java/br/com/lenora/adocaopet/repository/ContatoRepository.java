package br.com.lenora.adocaopet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lenora.adocaopet.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
  
}
