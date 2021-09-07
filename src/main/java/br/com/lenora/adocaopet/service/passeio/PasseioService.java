package br.com.lenora.adocaopet.service.passeio;

import java.util.List;

import br.com.lenora.adocaopet.api.request.PasseioParametros;
import br.com.lenora.adocaopet.model.Passeio;

public interface PasseioService {

  List<Passeio> retornaPorUsuario(Integer idUsuario);

  Passeio gravarPasseio(Passeio request);

  Passeio alterarPasseio(Integer idPasseio, Passeio request);

  void deletarPasseio(Integer idPasseio);

  Passeio retornaPorid(Integer idPasseio);

  List<Passeio> retornaComParametros(PasseioParametros request);
  
}
