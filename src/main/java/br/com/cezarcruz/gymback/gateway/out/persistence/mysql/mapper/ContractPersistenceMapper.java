package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gymback.core.domain.Contract;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.ContractEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = {
        PaymentPersistenceMapper.class,
        StudentPersistenceMapper.class
    }
)
public interface ContractPersistenceMapper {
  Contract fromEntity(final ContractEntity source);
  ContractEntity fromModel(final Contract source);
}
