package br.com.cezarcruz.gymback.core.usecase.payment;

import br.com.cezarcruz.gymback.core.domain.Contract;
import br.com.cezarcruz.gymback.core.domain.Payment;
import br.com.cezarcruz.gymback.core.enums.PaymentType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CreatePaymentUseCase {

  public List<Payment> create(final Contract contract) {

    var contractMonths = contract.contractMonths();

    final List<Payment> payments = new ArrayList<>();
    LocalDate today = LocalDate.now();

    for (int i = 0; i < contractMonths; i++) {
      var nextPayment = today.plusMonths(1);
      payments.add(new Payment(null, BigDecimal.TEN, nextPayment, PaymentType.IN));
      today = nextPayment;
    }

    return payments;

  }

}
