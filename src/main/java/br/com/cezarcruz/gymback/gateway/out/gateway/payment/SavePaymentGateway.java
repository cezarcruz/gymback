package br.com.cezarcruz.gymback.gateway.out.gateway.payment;

import br.com.cezarcruz.gymback.core.domain.Payment;
import br.com.cezarcruz.gymback.gateway.out.gateway.SaveGateway;
import java.util.List;

public interface SavePaymentGateway extends SaveGateway<Payment> {
  List<Payment> saveAll(final List<Payment> list);
}
