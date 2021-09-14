package br.com.lenora.adocaopet.service.hospedagem;

import java.util.List;

import br.com.lenora.adocaopet.api.request.HospedagemParemetros;
import br.com.lenora.adocaopet.model.Hospedagem;

public interface HospedagemService {

  List<Hospedagem> retornaTodos();

  List<Hospedagem> retornaComParametros(HospedagemParemetros request);

  Hospedagem gravarHospedagem(Hospedagem request);

  Hospedagem retornaPorId(Integer idHospedagem);

  void deletarHospedagem(Integer idHospedagem);

  Hospedagem alterarHospedagem(Integer idHospedagem, Hospedagem request);

  List<Hospedagem> retornaPorUsuario(Integer idUsuario);
  
}
