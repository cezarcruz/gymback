package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.persistence.out.mysql.entity.ContactEntity;
import br.com.gymback.core.domain.ContactDomain;
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