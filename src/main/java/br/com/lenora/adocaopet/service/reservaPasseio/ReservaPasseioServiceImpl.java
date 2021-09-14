package br.com.lenora.adocaopet.service.reservaPasseio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lenora.adocaopet.exception.ErroServidorException;
import br.com.lenora.adocaopet.exception.VazioException;
import br.com.lenora.adocaopet.model.ReservaPasseio;
import br.com.lenora.adocaopet.repository.ReservaPasseioRepository;

@Service
public class ReservaPasseioServiceImpl implements ReservaPasseioService {
  @Autowired
  ReservaPasseioRepository repository;

  @Override
  public List<ReservaPasseio> retornaPorCliente(Integer idUsuario) {
    List<ReservaPasseio> listaReservaPasseio = new ArrayList<>();
    
    try {
      listaReservaPasseio = repository.findByIdCliente(idUsuario);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaReservaPasseio.size() > 0) {
      return listaReservaPasseio;
    }

    throw new VazioException("Não foi encontrado nenhum passeio.");
  }

  @Override
  public ReservaPasseio gravarReservaPasseio(ReservaPasseio request) {
    try {
      return repository.save(request);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }
  }

  @Override
  public void deletarReservaPasseio(Integer idReservaPasseio) {
    try {
      repository.deleteById(idReservaPasseio);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }  
    
  }

  @Override
  public List<ReservaPasseio> retornaPorProfissional(Integer idUsuario) {
    List<ReservaPasseio> listaReservaPasseio = new ArrayList<>();
    
    try {
      listaReservaPasseio = repository.findByIdProfissional(idUsuario);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaReservaPasseio.size() > 0) {
      return listaReservaPasseio;
    }

    throw new VazioException("Não foi encontrado nenhum passeio.");
  }
}
