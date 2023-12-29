package br.com.cezarcruz.gymback.core.usecase.payment;

import br.com.cezarcruz.gymback.core.domain.Contract;
import br.com.cezarcruz.gymback.core.domain.Payment;
import br.com.cezarcruz.gymback.core.enums.PaymentStatus;
import br.com.cezarcruz.gymback.core.enums.PaymentType;
import br.com.cezarcruz.gymback.gateway.out.gateway.payment.SavePaymentGateway;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePaymentUseCase {

  private final SavePaymentGateway savePaymentGateway;

  public List<Payment> create(final Contract contract) {

    var contractMonths = contract.contractMonths();

    final List<Payment> payments = new ArrayList<>();
    LocalDate nextPayment = contract.getStartDate();

    for (int i = 0; i < contractMonths; i++) {
      payments.add(new Payment(null, contract.getClassRoom().value(), nextPayment, PaymentType.IN, PaymentStatus.PENDING));
      nextPayment = nextPayment.plusMonths(1);
    }

    return payments
        .stream()
        .map(savePaymentGateway::save)
        .collect(Collectors.toList());

  }

}
