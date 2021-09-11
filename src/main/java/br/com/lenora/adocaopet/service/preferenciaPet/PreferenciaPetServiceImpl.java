package br.com.lenora.adocaopet.service.preferenciaPet;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lenora.adocaopet.exception.ErroServidorException;
import br.com.lenora.adocaopet.exception.VazioException;
import br.com.lenora.adocaopet.model.PreferenciaPet;
import br.com.lenora.adocaopet.repository.PreferenciaPetRepositorio;

@Service
public class PreferenciaPetServiceImpl implements PreferenciaPetService {
  @Autowired
  private PreferenciaPetRepositorio repository;

  @Override
  public PreferenciaPet retornaMatchPorIdUsuario(Integer idUsuario) {    
    PreferenciaPet preferenciaPet = retornaMatchPorIdUsuarioRepository(idUsuario);             

    if (preferenciaPet != null) {
      return preferenciaPet;
    }

    throw new VazioException("Você ainda não tem Matches cadastrados.");
  }

  @Override
  public PreferenciaPet gravarPreferenciaPet(PreferenciaPet request) { 
    PreferenciaPet preferenciaPet = retornaMatchPorIdUsuarioRepository(request.getUsuario().getIdUsuario());

    if (preferenciaPet != null) {
      request.setIdPreferenciaPet(preferenciaPet.getIdPreferenciaPet());
    }    

    try {
      return repository.save(request);

    } catch (Exception ex) {
      throw new ErroServidorException(ex.getCause().getCause().getMessage());
    }      
  }

  private PreferenciaPet retornaMatchPorIdUsuarioRepository(Integer idUsuario){
    Optional<PreferenciaPet> preferenciaPet;

    try {
      preferenciaPet = repository.findByIdUsuario(idUsuario);
  
    } catch (Exception ex) {
      throw new ErroServidorException(ex.getCause().getCause().getMessage());
    } 

    if (preferenciaPet.isPresent()) {
      return preferenciaPet.get();
    } else {
      return null;
    }
  } 
}
