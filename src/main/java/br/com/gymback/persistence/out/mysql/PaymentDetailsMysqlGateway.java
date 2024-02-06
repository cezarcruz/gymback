package br.com.gymback.persistence.out.mysql;

import br.com.gymback.core.domain.PaymentDetailsDomain;
import br.com.gymback.core.gateway.paymentdetails.SavePaymentDetailsGateway;
import br.com.gymback.persistence.out.mysql.mapper.PaymentDetailsPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.PaymentDetailsRepository;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class PaymentDetailsMysqlGateway implements SavePaymentDetailsGateway {

  private final PaymentDetailsRepository paymentDetailsRepository;
  private final PaymentDetailsPersistenceMapper mapper;

  @Override
  public PaymentDetailsDomain save(final PaymentDetailsDomain paymentDetails) {
    var toSave = mapper.fromDomain(paymentDetails);
    var saved = paymentDetailsRepository.save(toSave);
    return mapper.fromEntity(saved);
  }
}
