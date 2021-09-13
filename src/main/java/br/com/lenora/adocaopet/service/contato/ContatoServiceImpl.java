package br.com.lenora.adocaopet.service.contato;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lenora.adocaopet.exception.ErroServidorException;
import br.com.lenora.adocaopet.exception.VazioException;
import br.com.lenora.adocaopet.model.Contato;
import br.com.lenora.adocaopet.repository.ContatoRepository;

@Service
public class ContatoServiceImpl implements ContatoService {
  @Autowired
  ContatoRepository repository;

  @Override
  public List<Contato> retornaTodos() {
    List<Contato> listaContato = new ArrayList<>();
    try {
      listaContato = repository.findAll();

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaContato.size() > 0) {
      return listaContato;
    }

    throw new VazioException("Não foi encontrado nenhum Contato");
  }

  @Override
  public Contato gravarContato(Contato request) {
    try {
      return repository.save(request);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }
  }

  @Override
  public void excluirContato(Integer idMensagem) {
    try {
      repository.deleteById(idMensagem);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }
    
  }
  
}
