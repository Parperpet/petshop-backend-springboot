package br.com.lenora.adocaopet.service.comentarios;

import java.util.List;

import br.com.lenora.adocaopet.api.response.ComentariosResponse;
import br.com.lenora.adocaopet.model.Comentarios;

public interface ComentariosService {

  List<ComentariosResponse> retornaPorUsuario(Integer idUsuario);

  Comentarios gravarComentario(Comentarios request);

  void deletarComentario(Integer idComentario);

  Comentarios aprovarComentario(Comentarios request);

  List<ComentariosResponse> retornaAprovados(Integer idUsuario);
  
}
