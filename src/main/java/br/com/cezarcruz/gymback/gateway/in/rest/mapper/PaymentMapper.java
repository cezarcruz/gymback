package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.PaymentDomain;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface PaymentMapper {

  PaymentResponse fromModel(final PaymentDomain source);

}
