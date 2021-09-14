package br.com.lenora.adocaopet.service.passeio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lenora.adocaopet.api.request.PasseioParametros;
import br.com.lenora.adocaopet.exception.ErroServidorException;
import br.com.lenora.adocaopet.exception.VazioException;
import br.com.lenora.adocaopet.model.Passeio;
import br.com.lenora.adocaopet.repository.PasseioRepository;

@Service
public class PasseioServiceImpl implements PasseioService{
  @Autowired
  PasseioRepository repository;

  @Override
  public List<Passeio> retornaPorUsuario(Integer idUsuario) {
    List<Passeio> listaPasseio = new ArrayList<>();

    try {
      listaPasseio = repository.findByIdUsuario(idUsuario);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaPasseio.size() > 0) {
      return listaPasseio;
    }

    throw new VazioException("Não foi encontrado nenhum passeio.");
  }  

  @Override
  public Passeio gravarPasseio(Passeio request) {
    try {
      return repository.save(request);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }
  }

  @Override
  public Passeio alterarPasseio(Integer idPasseio, Passeio request) { 
    return gravarPasseio(request);
  }

  @Override
  public void deletarPasseio(Integer idPasseio) {      
    try {
      repository.deleteById(idPasseio);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }   
  }

  @Override
  public Passeio retornaPorid(Integer idPasseio) {
    Optional<Passeio> passeio;

    try {
      passeio = repository.findById(idPasseio);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (passeio.isPresent()) {
      return passeio.get();
    }

    throw new VazioException("Não foi encontrado nenhum passeio.");
  }

  @Override
  public List<Passeio> retornaComParametros(PasseioParametros request) {
    List<Passeio> listaPasseio = new ArrayList<>();

    String cidade = "%" + request.getCidade() + "%";
    String bairro = "%" + request.getBairro() + "%";

    try {
      listaPasseio = repository.findByPasseiosPorParametro(bairro, cidade, request.getEstado(), 
                                                           request.getFrequenciaDiaria(), request.getPrecoMensal());

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaPasseio.size() > 0) {
      return listaPasseio;
    }

    throw new VazioException("Não foi encontrado nenhum passeio com os parâmetros passados.");
  }
  
}
