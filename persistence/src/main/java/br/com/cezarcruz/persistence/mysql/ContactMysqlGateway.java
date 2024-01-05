package br.com.cezarcruz.persistence.mysql;

import br.com.cezarcruz.core.domain.ContactDomain;
import br.com.cezarcruz.core.gateway.contact.SaveContactGateway;
import br.com.cezarcruz.persistence.mysql.mapper.ContactPersistenceMapper;
import br.com.cezarcruz.persistence.mysql.repository.ContactRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactMysqlGateway implements SaveContactGateway {

  private final ContactRepository contactRepository;
  private final ContactPersistenceMapper contactPersistenceMapper;

  @Override
  public List<ContactDomain> save(final List<ContactDomain> contacts) {
    final var contactEntities = contactPersistenceMapper.fromDomain(contacts);
    return contactPersistenceMapper.fromEntity(contactRepository.saveAll(contactEntities));
  }
}
