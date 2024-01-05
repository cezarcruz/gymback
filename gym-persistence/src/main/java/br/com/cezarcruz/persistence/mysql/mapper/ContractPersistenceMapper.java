package br.com.cezarcruz.persistence.mysql.mapper;

import br.com.cezarcruz.core.domain.ContractDomain;
import br.com.cezarcruz.persistence.mysql.entity.ContractEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = {
        PaymentPersistenceMapper.class,
        StudentPersistenceMapper.class,
        ClassRoomPersistenceMapper.class
    }
)
public interface ContractPersistenceMapper {

  @Mapping(target = "withStudent", ignore = true)
  @Mapping(target = "withPayments", ignore = true)
  ContractDomain fromEntity(final ContractEntity source);
  ContractEntity fromModel(final ContractDomain source);
}
