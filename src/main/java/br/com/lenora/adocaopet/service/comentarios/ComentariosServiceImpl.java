package br.com.lenora.adocaopet.service.comentarios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lenora.adocaopet.api.response.ComentariosResponse;
import br.com.lenora.adocaopet.exception.ErroServidorException;
import br.com.lenora.adocaopet.exception.VazioException;
import br.com.lenora.adocaopet.model.Comentarios;
import br.com.lenora.adocaopet.repository.ComentariosRepository;
import br.com.lenora.adocaopet.repository.UsuarioRepository;

@Service
public class ComentariosServiceImpl implements ComentariosService {
  @Autowired
  ComentariosRepository repository;

  @Autowired
  UsuarioRepository usuarioRepository;

  @Override
  public List<ComentariosResponse> retornaPorUsuario(Integer idUsuario) {
    List<Comentarios> listaComentarios = new ArrayList<>();
    List<ComentariosResponse> listaComentariosResponse = new ArrayList<>();

    try {
      listaComentarios = repository.findByIdProfissional(idUsuario);

      if (listaComentarios.size() > 0) {
        listaComentarios.forEach(list ->{
          ComentariosResponse response = new ComentariosResponse();
          response.setIdComentario(list.getIdComentario());
          response.setAprovadoAdm(list.isAprovadoAdm());
          response.setComentario(list.getComentario());
          response.setIdProfissional(list.getIdProfissional());
          response.setIdCliente(usuarioRepository.findById(list.getIdCliente()).get());

          listaComentariosResponse.add(response);
        });

        return listaComentariosResponse;
      }

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    throw new VazioException("Não foi encontrado nenhum comentario para o usuario " + idUsuario);
  }

  @Override
  public Comentarios gravarComentario(Comentarios request) {
    try {
      return repository.save(request);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }
  }
  
  @Override
  public Comentarios aprovarComentario(Comentarios request) {
    return gravarComentario(request);
  }

  @Override
  public void deletarComentario(Integer idComentario) {
    repository.deleteById(idComentario);
  }

  @Override
  public List<ComentariosResponse> retornaAprovados(Integer idUsuario) {
    List<ComentariosResponse> listaComentariosResponse = retornaPorUsuario(idUsuario);
    List<ComentariosResponse> listaAprovados = new ArrayList<>();

    listaComentariosResponse.forEach(list ->{    
      if (list.isAprovadoAdm()) {
        listaAprovados.add(list);
      }
    });

    return listaAprovados;
  }
}
