package br.com.lenora.adocaopet.service.reservaHospedagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lenora.adocaopet.exception.ErroServidorException;
import br.com.lenora.adocaopet.exception.VazioException;
import br.com.lenora.adocaopet.model.ReservaHospedagem;
import br.com.lenora.adocaopet.repository.ReservaHospedagemRepository;

@Service
public class ReservaHospedagemServiceImpl implements ReservaHospedagemService{
  @Autowired
  private ReservaHospedagemRepository repository;

  @Override
  public List<ReservaHospedagem> retornaTodos() {
    List<ReservaHospedagem> listaReservaHospedagem = new ArrayList<>();
    try {
      listaReservaHospedagem = repository.findAll();

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaReservaHospedagem.size() > 0) {
      return listaReservaHospedagem;
    }

    throw new VazioException("Não foi encontrado nenhuma reserva");
  }  

  @Override
  public ReservaHospedagem retornaPorId(Integer idReservaHospedagem) {
    Optional<ReservaHospedagem> reservaHospedagem;    
    try {
      reservaHospedagem = repository.findById(idReservaHospedagem);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (reservaHospedagem.isPresent()) {
      return reservaHospedagem.get();
    }

    throw new VazioException("Não foi encontrado nenhuma reserva com o id " + idReservaHospedagem);
  }  

  @Override
  public ReservaHospedagem gravarReservaHospedagem(ReservaHospedagem request) {
    try {
      return repository.save(request);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }
  }
  
}
