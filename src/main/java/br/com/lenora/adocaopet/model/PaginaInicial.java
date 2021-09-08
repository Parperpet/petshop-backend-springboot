package br.com.lenora.adocaopet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PaginaInicial {
  @Id
  private Integer idPaginaInicial;
  @Column(columnDefinition = "text")
  private String fotoPrincipalBase64;
  @Column(columnDefinition = "text")
  private String fotoDica1Base64;
  @Column(columnDefinition = "text")
  private String dica1;
  @Column(columnDefinition = "text")
  private String fotoDica2Base64;
  @Column(columnDefinition = "text")
  private String dica2;
  private Integer profissional;
  @Column(columnDefinition = "text")
  private String descricaoProfissional;
  private Integer hospedagem;
  @Column(columnDefinition = "text")
  private String descricaoHospedagem;
  private Integer comentario1;
  private Integer comentario2;
  private Integer comentario3;
}
