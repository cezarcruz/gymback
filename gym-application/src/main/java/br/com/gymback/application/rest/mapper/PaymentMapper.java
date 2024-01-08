package br.com.gymback.application.rest.mapper;

import br.com.gymback.application.rest.dto.response.PaymentResponse;
import br.com.gymback.core.domain.PaymentDomain;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface PaymentMapper {

  PaymentResponse fromModel(final PaymentDomain source);

}
