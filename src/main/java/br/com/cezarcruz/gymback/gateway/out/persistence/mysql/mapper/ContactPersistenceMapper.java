package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gymback.core.domain.Contact;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.ContactEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = ComponentModel.JAKARTA, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactPersistenceMapper {
  List<Contact> fromEntity(final List<ContactEntity> contactEntities);
  List<ContactEntity> fromDomain(final List<Contact> contacts);

}
