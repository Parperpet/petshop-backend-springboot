package br.com.lenora.adocaopet.service.mensagem;

import java.util.List;

import br.com.lenora.adocaopet.model.Mensagem;

public interface MensagemService {

  List<Mensagem> retornaHistoricoConversa(Integer idUsuario);

  Mensagem gravarMensagem(Mensagem request);

  void verificaExistenciaChat(Mensagem request);

  Mensagem gravarNovaMensagem(Mensagem request);

  void excluirChat(Integer idChat);
  
}
