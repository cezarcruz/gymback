package br.com.cezarcruz.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gateway.out.persistence.mysql.entity.ContactEntity;
import br.com.cezarcruz.gymback.core.domain.ContactDomain;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.JAKARTA)
public interface ContactPersistenceMapper {
  List<ContactDomain> fromEntity(final List<ContactEntity> contactEntities);
  List<ContactEntity> fromDomain(final List<ContactDomain> contacts);
  ContactDomain fromEntity(final ContactEntity contactEntities);
  ContactEntity fromDomain(final ContactDomain contacts);

}
