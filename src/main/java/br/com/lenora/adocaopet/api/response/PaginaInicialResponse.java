package br.com.lenora.adocaopet.api.response;

import java.util.List;

import br.com.lenora.adocaopet.model.Hospedagem;
import br.com.lenora.adocaopet.model.Usuario;
import lombok.Data;

@Data
public class PaginaInicialResponse {
  private Integer idPaginaInicial;
  private String fotoPrincipalBase64;
  private String fotoDica1Base64;
  private String dica1;
  private String fotoDica2Base64;
  private String dica2;
  private Usuario profissional;
  private String descricaoProfissional;
  private Hospedagem hospedagem;
  private String descricaoHospedagem;
  
  private List<ComentariosResponse> comentarios;
}
