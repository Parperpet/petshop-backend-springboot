package br.com.lenora.adocaopet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.lenora.adocaopet.model.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Integer>{ 
  List<Mensagem> findByIdChat(Integer idChat);

  @Query(value = "SELECT EXISTS(                       " +
                 "  SELECT * FROM mensagem             " +
                 "  WHERE remetente = :idRemetente     " +
                 "  AND destinatario = :idDestinatario " +
                 "  AND pet = :idPet                   " +
                 ")                                    ", nativeQuery = true)
  boolean verificaExistenciaChat(Integer idRemetente, Integer idDestinatario, Integer idPet);

  @Query(value = "SELECT MAX(id_chat) FROM mensagem", nativeQuery = true)
  Optional<Integer> findByMaxIdChat();

  @Query(value = "SELECT * FROM mensagem                    " +
                 "WHERE destinatario = :idUsuario           " +
                 "OR remetente = :idUsuario                 " +
                 "ORDER BY id_chat DESC, id_mensagem DESC   ", nativeQuery = true)
  List<Mensagem> findByConversas(Integer idUsuario);

  void deleteByIdChat(Integer idChat);
}
