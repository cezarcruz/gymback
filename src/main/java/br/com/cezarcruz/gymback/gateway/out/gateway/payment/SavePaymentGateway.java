package br.com.cezarcruz.gymback.gateway.out.gateway.payment;

import br.com.cezarcruz.gymback.core.domain.PaymentDomain;
import br.com.cezarcruz.gymback.gateway.out.gateway.SaveGateway;
import java.util.List;

public interface SavePaymentGateway extends SaveGateway<PaymentDomain> {
  List<PaymentDomain> saveAll(final List<PaymentDomain> list);
}
