package br.com.lenora.adocaopet.service.pet;

import java.util.List;

import br.com.lenora.adocaopet.model.Pet;
import br.com.lenora.adocaopet.model.PreferenciaPet;

public interface PetService {

  List<Pet> retornaTodos();

  Pet retornaPorId(Integer idPet);

  Pet gravarPet(Pet request);

  Pet alterarPet(Integer idPet, Pet request);

  void deletarPet(Integer idPet);

  List<Pet> retornaPetsDisponiveisParaAdocao();

  List<Pet> retornaPetsCompativeisComPerfil(PreferenciaPet request);

  List<Pet> retornaMeusPets(Integer idUsuario);
  
}
