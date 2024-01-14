package br.com.gymback.core.usecase.payment;

import br.com.gymback.core.domain.PaymentDomain;
import br.com.gymback.core.enums.PaymentStatus;
import br.com.gymback.core.gateway.payment.GetPaymentGateway;
import jakarta.inject.Named;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class GetPaymentUseCase {
  private final GetPaymentGateway getPaymentGateway;

  public List<PaymentDomain> findBy(final Long contractId, final PaymentStatus paymentStatus) {
    return getPaymentGateway.findBy(contractId, paymentStatus);
  }
}
