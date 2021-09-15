package br.com.lenora.adocaopet.service.pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lenora.adocaopet.exception.ErroServidorException;
import br.com.lenora.adocaopet.exception.VazioException;
import br.com.lenora.adocaopet.model.Pet;
import br.com.lenora.adocaopet.model.PreferenciaPet;
import br.com.lenora.adocaopet.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService{
  @Autowired
  private PetRepository repository;

  @Override
  public List<Pet> retornaTodos() {
    List<Pet> listaPet = new ArrayList<>();
    try {
      listaPet = repository.findAll();

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaPet.size() > 0) {
      return listaPet;
    }

    throw new VazioException("Não foi encontrado nenhum pet");     
  }

  @Override
  public List<Pet> retornaPetsDisponiveisParaAdocao() {
    List<Pet> listaPet = new ArrayList<>();
    try {
      listaPet = repository.findByDisponivelParaAdocaoIsTrue();

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaPet.size() > 0) {
      return listaPet;
    }

    throw new VazioException("Não foi encontrado nenhum pet"); 
  }

  @Override
  public List<Pet> retornaPetsCompativeisComPerfil(PreferenciaPet request) {
    List<Pet> listaPet = new ArrayList<>();

    try {
      listaPet = repository.buscaMatchComParametros(request.getIdade(), request.getEspecie(), request.getCor(), request.getPorte(), 
                                                    request.getOlhos(), request.getCustoMensal(), request.getUsuario().getIdUsuario(), request.getSexo());

    } catch (Exception e) {
      System.out.println(e);
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaPet.size() > 0) {
      return listaPet;
    }

    throw new VazioException("Não foi encontrado nenhum pet compativel"); 
  }

  @Override
  public Pet retornaPorId(Integer idPet) {
    Optional<Pet> pet;    
    try {
      pet = repository.findById(idPet);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (pet.isPresent()) {
      return pet.get();
    }

    throw new VazioException("Não foi encontrado nenhum pet com o id " + idPet);
  }

  @Override
  public Pet gravarPet(Pet request) {       
    try {
      return repository.save(request);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }
  }

  @Override
  public Pet alterarPet(Integer idPet, Pet request) {
    retornaPorId(idPet);
    request.setIdPet(idPet);

    return gravarPet(request);
  }

  @Override
  public void deletarPet(Integer idPet) {
    retornaPorId(idPet);

    repository.deleteById(idPet);    
  }

  @Override
  public List<Pet> retornaMeusPets(Integer idUsuario) {
    List<Pet> listaPet = new ArrayList<>();

    try {
      listaPet = repository.findByIdDono(idUsuario);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaPet.size() > 0) {
      return listaPet;
    }

    throw new VazioException("Não foi encontrado nenhum pet");
  }

  

  
}
