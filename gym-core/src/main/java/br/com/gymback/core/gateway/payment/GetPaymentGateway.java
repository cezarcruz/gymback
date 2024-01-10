package br.com.gymback.core.gateway.payment;

import br.com.gymback.core.domain.PaymentDomain;
import java.util.List;

public interface GetPaymentGateway {
  List<PaymentDomain> getByStudent(final String studentId);
}
