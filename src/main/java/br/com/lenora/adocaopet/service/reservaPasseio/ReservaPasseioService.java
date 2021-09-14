package br.com.lenora.adocaopet.service.reservaPasseio;

import java.util.List;
import br.com.lenora.adocaopet.model.ReservaPasseio;

public interface ReservaPasseioService {

  List<ReservaPasseio> retornaPorCliente(Integer idUsuario);

  ReservaPasseio gravarReservaPasseio(ReservaPasseio request);

  void deletarReservaPasseio(Integer idReservaPasseio);

  List<ReservaPasseio> retornaPorProfissional(Integer idUsuario);
  
}
