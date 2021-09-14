package br.com.lenora.adocaopet.service.hospedagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lenora.adocaopet.api.request.HospedagemParemetros;
import br.com.lenora.adocaopet.exception.ErroServidorException;
import br.com.lenora.adocaopet.exception.VazioException;
import br.com.lenora.adocaopet.model.Hospedagem;
import br.com.lenora.adocaopet.repository.HospedagemRepository;

@Service
public class HospedagemServiceImpl implements HospedagemService{
  @Autowired
  private HospedagemRepository repository;

  @Override
  public List<Hospedagem> retornaTodos() {
    List<Hospedagem> listaHospedagem = new ArrayList<>();

    try {
      listaHospedagem = repository.findAll();

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaHospedagem.size() > 0) {
      return listaHospedagem;
    }

    throw new VazioException("Não foi encontrado nenhuma hospedagem");
  }

  @Override
  public List<Hospedagem> retornaComParametros(HospedagemParemetros request) {
    List<Hospedagem> listaHospedagem = new ArrayList<>();

    try {
      listaHospedagem = repository.findByComParametros(request.getCidade(), request.getTipo(), request.getEspecieAceita(), request.getPorteAceito(), request.getPrecoDiaria());

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaHospedagem.size() > 0) {
      return listaHospedagem;
    }

    throw new VazioException("Não foi encontrado nenhuma hospedagem com os parâmetros passados");
  }

  @Override
  public Hospedagem gravarHospedagem(Hospedagem request) {
    try {
      return repository.save(request);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }
  }

  @Override
  public Hospedagem retornaPorId(Integer idHospedagem) {
    Optional<Hospedagem> hospedagem;    
    try {
      hospedagem = repository.findById(idHospedagem);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (hospedagem.isPresent()) {
      return hospedagem.get();
    }

    throw new VazioException("Não foi encontrado nenhuma hospedagem com o id " + idHospedagem);
  }

  @Override
  public void deletarHospedagem(Integer idHospedagem) {
    retornaPorId(idHospedagem);

    repository.deleteById(idHospedagem);    
  }

  @Override
  public Hospedagem alterarHospedagem(Integer idHospedagem, Hospedagem request) {
    retornaPorId(idHospedagem);

    return gravarHospedagem(request);
  }

  @Override
  public List<Hospedagem> retornaPorUsuario(Integer idUsuario) {
    List<Hospedagem> listaHospedagem = new ArrayList<>();

    try {
      listaHospedagem = repository.findByIdUsuario(idUsuario);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaHospedagem.size() > 0) {
      return listaHospedagem;
    }

    throw new VazioException("Não foi encontrado nenhuma hospedagem");
  }
  
}
