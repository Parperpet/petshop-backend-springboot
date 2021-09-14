package br.com.lenora.adocaopet.api.response;

import br.com.lenora.adocaopet.model.Usuario;
import lombok.Data;

@Data
public class ComentariosResponse {
  private Integer idComentario;
  private Integer idProfissional;
  private Usuario idCliente;
  private String comentario;
  private boolean aprovadoAdm;
}
