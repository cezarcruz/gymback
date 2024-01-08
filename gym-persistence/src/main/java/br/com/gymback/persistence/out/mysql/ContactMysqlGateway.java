package br.com.gymback.persistence.out.mysql;

import br.com.gymback.persistence.out.mysql.mapper.ContactPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.ContactRepository;
import br.com.gymback.core.domain.ContactDomain;
import br.com.gymback.core.gateway.contact.SaveContactGateway;
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
