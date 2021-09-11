package br.com.lenora.adocaopet.service.preferenciaPet;

import br.com.lenora.adocaopet.model.PreferenciaPet;

public interface PreferenciaPetService {

  PreferenciaPet retornaMatchPorIdUsuario(Integer idUsuario);

  PreferenciaPet gravarPreferenciaPet(PreferenciaPet request);
  
}
