/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.payment;

import br.com.gymback.core.domain.PaymentDomain;
import br.com.gymback.core.enums.PaymentStatus;
import br.com.gymback.core.gateway.payment.GetPaymentGateway;
import br.com.gymback.core.gateway.payment.SavePaymentGateway;
import jakarta.inject.Named;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
@RequiredArgsConstructor
public class UpdateOverduePaymentUseCase {

  private final GetPaymentGateway getPaymentGateway;
  private final SavePaymentGateway savePaymentGateway;

  public void execute() {
    final List<PaymentDomain> pendingPayments =
        getPaymentGateway.findAllBy(PaymentStatus.PENDING, LocalDate.now()).stream()
            .map(payment -> payment.toBuilder().paymentStatus(PaymentStatus.OVERDUE).build())
            .toList();

    log.info("updating {} payments", pendingPayments.size());

    savePaymentGateway.saveAll(pendingPayments);
  }
}
