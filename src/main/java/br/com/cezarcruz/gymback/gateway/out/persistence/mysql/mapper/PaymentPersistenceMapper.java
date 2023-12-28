package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gymback.core.domain.Payment;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface PaymentPersistenceMapper {
  Payment fromEntity(final PaymentEntity source);
  PaymentEntity fromModel(final Payment source);
}
