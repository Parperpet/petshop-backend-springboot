package br.com.lenora.adocaopet.service.preferenciaPet;

import java.util.List;

import br.com.lenora.adocaopet.model.Pet;
import br.com.lenora.adocaopet.model.PreferenciaPet;

public interface PreferenciaPetService {

  PreferenciaPet retornaMatchPorIdUsuario(Integer idUsuario);

  PreferenciaPet gravarPreferenciaPet(PreferenciaPet request);

  List<PreferenciaPet> retornaUsuariosCompativeisComPet(Pet request);
  
}
