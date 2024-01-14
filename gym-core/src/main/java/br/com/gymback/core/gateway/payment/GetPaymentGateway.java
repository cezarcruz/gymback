package br.com.gymback.core.gateway.payment;

import br.com.gymback.core.domain.PaymentDomain;
import br.com.gymback.core.enums.PaymentStatus;
import java.util.List;

public interface GetPaymentGateway {

  List<PaymentDomain> findBy(Long contractId, PaymentStatus paymentStatus);
}
