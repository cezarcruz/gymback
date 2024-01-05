package br.com.cezarcruz.core.usecase.payment;

import br.com.cezarcruz.core.domain.ContractDomain;
import br.com.cezarcruz.core.domain.PaymentDomain;
import br.com.cezarcruz.core.enums.PaymentStatus;
import br.com.cezarcruz.core.enums.PaymentType;
import br.com.cezarcruz.core.gateway.payment.SavePaymentGateway;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePaymentUseCase {

  private final SavePaymentGateway savePaymentGateway;

  public List<PaymentDomain> create(final ContractDomain contract) {

    var contractMonths = contract.contractMonths();

    final List<PaymentDomain> payments = new ArrayList<>();
    LocalDate nextPayment = contract.getStartDate();

    for (int i = 0; i < contractMonths; i++) {
      payments.add(new PaymentDomain(null, contract.getClassRoom().value(), nextPayment, PaymentType.IN, PaymentStatus.PENDING));
      nextPayment = nextPayment.plusMonths(1);
    }

    return savePaymentGateway.saveAll(payments);

  }

}
