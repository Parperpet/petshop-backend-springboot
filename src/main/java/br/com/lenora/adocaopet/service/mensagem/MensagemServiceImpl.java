package br.com.lenora.adocaopet.service.mensagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lenora.adocaopet.exception.ChatExistenteException;
import br.com.lenora.adocaopet.exception.ErroServidorException;
import br.com.lenora.adocaopet.exception.VazioException;
import br.com.lenora.adocaopet.model.Mensagem;
import br.com.lenora.adocaopet.repository.MensagemRepository;

@Service
public class MensagemServiceImpl implements MensagemService{
  @Autowired
  private MensagemRepository repository;

  @Override
  public List<Mensagem> retornaHistoricoConversa(Integer idUsuario) {
    List<Mensagem> listaMensagem = new ArrayList<>();
    try {
      listaMensagem = repository.findByConversas(idUsuario);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }

    if (listaMensagem.size() > 0) {
      return listaMensagem;
    }

    throw new VazioException("Não foi encontrado nenhuma conversa");
  }

  @Override
  public Mensagem gravarMensagem(Mensagem request) {
    try {
      Optional<Integer> maxid = repository.findByMaxIdChat();
      
      if (maxid.isPresent()) {
        request.setIdChat(maxid.get() + 1);

      }else {
        request.setIdChat(1);
      }
      
      return repository.save(request);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }
  }

  @Override
  public void verificaExistenciaChat(Mensagem request){
    if (repository.verificaExistenciaChat(request.getRemetente().getIdUsuario(), request.getDestinatario().getIdUsuario(), 
                                          request.getPet().getIdPet())) {
      throw new ChatExistenteException();
    }
  }

  @Override
  public Mensagem gravarNovaMensagem(Mensagem request) {
    try { 
      return repository.save(request);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }
  }

  @Override
  public void excluirChat(Integer idChat) {
    try {
      repository.deleteByIdChat(idChat);

    } catch (Exception e) {
      throw new ErroServidorException(e.getCause().getCause().getMessage());
    }
    
  }  
  
}
