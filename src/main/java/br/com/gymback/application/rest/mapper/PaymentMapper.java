package br.com.gymback.application.rest.mapper;

import br.com.gymback.application.rest.dto.request.DoPaymentRequest;
import br.com.gymback.application.rest.dto.response.PaymentResponse;
import br.com.gymback.core.domain.PaymentDomain;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(
    componentModel = ComponentModel.JAKARTA
)
public interface PaymentMapper {

  PaymentResponse fromModel(final PaymentDomain source);

  @Mapping(source = "source.method", target = "paymentMethod")
  PaymentDomain fromDoPaymentRequest(final DoPaymentRequest source, final Long id);

  @InheritConfiguration
  List<PaymentResponse> fromModelList(List<PaymentDomain> payments);
}
