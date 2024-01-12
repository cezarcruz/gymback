package br.com.gymback.core.domain;

import br.com.gymback.core.enums.PaymentMethod;
import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class PaymentDetailsDomain {
  private final Long id;
  private final PaymentDomain payment;
  private final PaymentMethod paymentMethod;
  private final BigDecimal value;
  private final BigDecimal paidValue;

  public PaymentDetailsDomain(final Long id,
      final PaymentDomain payment,
      final PaymentMethod paymentMethod,
      final BigDecimal value,
      final BigDecimal paidValue) {
    this.id = id;
    this.payment = payment;
    this.paymentMethod = paymentMethod;
    this.value = value;
    this.paidValue = paidValue;
  }
}
