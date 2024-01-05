package br.com.cezarcruz.core.gateway.payment;

import br.com.cezarcruz.core.domain.PaymentDomain;
import br.com.cezarcruz.core.gateway.SaveGateway;
import java.util.List;

public interface SavePaymentGateway extends SaveGateway<PaymentDomain> {
  List<PaymentDomain> saveAll(final List<PaymentDomain> list);
}
