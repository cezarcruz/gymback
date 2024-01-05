package br.com.cezarcruz.application.rest.mapper;

import br.com.cezarcruz.application.rest.dto.response.PaymentResponse;
import br.com.cezarcruz.core.domain.PaymentDomain;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface PaymentMapper {

  PaymentResponse fromModel(final PaymentDomain source);

}
