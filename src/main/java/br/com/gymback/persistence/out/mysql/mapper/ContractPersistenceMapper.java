/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.core.domain.ContractDomain;
import br.com.gymback.persistence.out.mysql.entity.ContractEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    uses = {
      PaymentPersistenceMapper.class,
      StudentPersistenceMapper.class,
      ClassRoomPersistenceMapper.class
    })
public interface ContractPersistenceMapper {

  @Mapping(target = "withStudent", ignore = true)
  @Mapping(target = "withPayments", ignore = true)
  ContractDomain fromEntity(final ContractEntity source);

  ContractEntity fromModel(final ContractDomain source);
}
