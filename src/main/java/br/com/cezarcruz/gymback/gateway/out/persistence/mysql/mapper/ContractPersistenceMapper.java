package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gymback.core.domain.Contract;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.ContractEntity;
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
  Contract fromEntity(final ContractEntity source);
  ContractEntity fromModel(final Contract source);
}
