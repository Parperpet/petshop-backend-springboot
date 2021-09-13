package br.com.lenora.adocaopet.service.contato;

import java.util.List;

import br.com.lenora.adocaopet.model.Contato;

public interface ContatoService {

  List<Contato> retornaTodos();

  Contato gravarContato(Contato request);

  void excluirContato(Integer idMensagem);
  
}
