package br.com.gymback.core.gateway.payment;

import br.com.gymback.core.domain.PaymentDomain;
import br.com.gymback.core.enums.PaymentStatus;
import java.time.LocalDate;
import java.util.List;

public interface GetPaymentGateway {

  List<PaymentDomain> findAllBy(PaymentStatus paymentStatus, LocalDate localDate);

  List<PaymentDomain> findBy(Long contractId, PaymentStatus paymentStatus);
}
