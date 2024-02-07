/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.payment;

import br.com.gymback.core.domain.ContractDomain;
import br.com.gymback.core.domain.PaymentDomain;
import br.com.gymback.core.gateway.payment.SavePaymentGateway;
import jakarta.inject.Named;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreatePaymentUseCase {

  private final SavePaymentGateway savePaymentGateway;

  public List<PaymentDomain> create(final ContractDomain contract) {

    var contractMonths = contract.contractMonths();

    final List<PaymentDomain> payments = new ArrayList<>();
    LocalDate nextPayment = contract.getStartDate();

    for (int i = 0; i < contractMonths; i++) {
      payments.add(PaymentDomain.createInPayment(contract.getClassRoom().value(), nextPayment));
      nextPayment = nextPayment.plusMonths(1);
    }

    return savePaymentGateway.saveAll(payments);
  }
}
