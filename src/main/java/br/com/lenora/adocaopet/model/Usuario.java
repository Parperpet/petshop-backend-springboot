package br.com.lenora.adocaopet.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idUsuario;
  private String nivelAcesso;
  private String nome;
	private String email;
	private String senha;
  private String cpf;	
  private String telefone;
  @Column(columnDefinition = "text")
  private String fotoPerfilBase64;
  private boolean cadastraHospedagem;
  private boolean cadastraAdocao;
  private boolean cadastraPasseio;
  private BigDecimal notaProfissional;
  private Integer qtdNotasRecebidas;
  private boolean aprovado;
}