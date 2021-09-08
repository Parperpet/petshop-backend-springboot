package br.com.lenora.adocaopet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lenora.adocaopet.model.PaginaInicial;

@Repository
public interface PaginaInicialRepository extends JpaRepository<PaginaInicial, Integer> {
  
}
