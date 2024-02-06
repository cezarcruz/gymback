/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql.mapper;

import br.com.gymback.core.domain.PaymentDetailsDomain;
import br.com.gymback.persistence.out.mysql.entity.PaymentDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.JAKARTA, uses = PaymentPersistenceMapper.class)
public interface PaymentDetailsPersistenceMapper {

  PaymentDetailsDomain fromEntity(final PaymentDetailsEntity source);

  PaymentDetailsEntity fromDomain(final PaymentDetailsDomain source);
}
