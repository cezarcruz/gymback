package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.Contact;
import br.com.cezarcruz.gymback.gateway.out.gateway.contact.SaveContactGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper.ContactPersistenceMapper;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.ContactRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactMysqlGateway implements SaveContactGateway {

  private final ContactRepository contactRepository;
  private final ContactPersistenceMapper contactPersistenceMapper;

  @Override
  public List<Contact> save(final List<Contact> contacts) {
    final var contactEntities = contactPersistenceMapper.fromDomain(contacts);
    return contactPersistenceMapper.fromEntity(contactRepository.saveAll(contactEntities));
  }
}
