package br.com.lenora.adocaopet.service.paginaInicial;

import br.com.lenora.adocaopet.api.response.PaginaInicialResponse;
import br.com.lenora.adocaopet.model.PaginaInicial;

public interface PaginaInicialService {

  PaginaInicialResponse retornaPaginaInicial();

  PaginaInicial gravarPaginaInicial(PaginaInicial request);
  
}
