package br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper;

import br.com.cezarcruz.gymback.core.domain.PaymentDomain;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.entity.PaymentEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface PaymentPersistenceMapper {
  PaymentDomain fromEntity(final PaymentEntity source);
  PaymentEntity fromModel(final PaymentDomain source);

  List<PaymentEntity> fromModelList(final List<PaymentDomain> source);
  List<PaymentDomain> fromEntityList(final List<PaymentEntity> source);
}
