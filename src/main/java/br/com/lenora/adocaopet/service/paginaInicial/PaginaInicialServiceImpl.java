package br.com.lenora.adocaopet.service.paginaInicial;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lenora.adocaopet.api.response.ComentariosResponse;
import br.com.lenora.adocaopet.api.response.PaginaInicialResponse;
import br.com.lenora.adocaopet.exception.ErroServidorException;
import br.com.lenora.adocaopet.exception.VazioException;
import br.com.lenora.adocaopet.model.PaginaInicial;
import br.com.lenora.adocaopet.repository.HospedagemRepository;
import br.com.lenora.adocaopet.repository.PaginaInicialRepository;
import br.com.lenora.adocaopet.repository.UsuarioRepository;
import br.com.lenora.adocaopet.service.comentarios.ComentariosService;

@Service
public class PaginaInicialServiceImpl implements PaginaInicialService {
  @Autowired
  PaginaInicialRepository repository;

  @Autowired
  UsuarioRepository usuarioRepository;

  @Autowired
  HospedagemRepository hospedagemRepository;

  @Autowired
  ComentariosService comentariosService;

  @Override
  public PaginaInicialResponse retornaPaginaInicial() {
    Optional<PaginaInicial> paginaInicial;       

    try {
      paginaInicial = repository.findById(1);

      if (paginaInicial.isPresent()) {
        PaginaInicialResponse response = new PaginaInicialResponse();
        response.setIdPaginaInicial(paginaInicial.get().getIdPaginaInicial());
        response.setFotoPrincipalBase64(paginaInicial.get().getFotoPrincipalBase64());
        response.setFotoDica1Base64(paginaInicial.get().getFotoDica1Base64());
        response.setDica1(paginaInicial.get().getDica1());
        response.setFotoDica2Base64(paginaInicial.get().getFotoDica2Base64());
        response.setDica2(paginaInicial.get().getDica2());
        response.setProfissional(usuarioRepository.findById(paginaInicial.get().getProfissional()).get());
        response.setDescricaoProfissional(paginaInicial.get().getDescricaoProfissional());
        response.setHospedagem(hospedagemRepository.findById(paginaInicial.get().getHospedagem()).get());
        response.setDescricaoHospedagem(paginaInicial.get().getDescricaoHospedagem());
        
        List<ComentariosResponse> listaComentariosResponse = new ArrayList<>();
        List<ComentariosResponse> listaComentarios = new ArrayList<>();

        listaComentariosResponse = (comentariosService.retornaPorUsuario(-1));

        listaComentariosResponse.forEach(list ->{
          if ((list.getIdComentario() == paginaInicial.get().getComentario1()) || (list.getIdComentario() == paginaInicial.get().getComentario2()) ||
             (list.getIdComentario() == paginaInicial.get().getComentario3())) {
             
            listaComentarios.add(list);
          }
        });

        response.setComentarios(listaComentarios);

        return response;
      }

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    throw new VazioException("Não foi encontrado nenhuma configuração.");
  }

  @Override
  public PaginaInicial gravarPaginaInicial(PaginaInicial request) {
    request.setIdPaginaInicial(1);

    try {
      return repository.save(request);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }
  }
  
}
