package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.persistence.out.mysql.entity.ContactEntity;
import br.com.gymback.core.domain.ContactDomain;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.JAKARTA)
public interface ContactPersistenceMapper {
  List<ContactDomain> fromEntity(final List<ContactEntity> sources);
  List<ContactEntity> fromDomain(final List<ContactDomain> sources);
  ContactDomain fromEntity(final ContactEntity source);
  ContactEntity fromDomain(final ContactDomain source);

}
