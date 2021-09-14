package br.com.lenora.adocaopet.service.reservaHospedagem;

import java.util.List;

import br.com.lenora.adocaopet.model.ReservaHospedagem;

public interface ReservaHospedagemService {

  List<ReservaHospedagem> retornaTodos();

  ReservaHospedagem retornaPorId(Integer idReservaHospedagem);

  ReservaHospedagem gravarReservaHospedagem(ReservaHospedagem request);
  
}
