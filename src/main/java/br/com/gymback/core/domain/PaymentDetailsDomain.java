package br.com.gymback.core.domain;

import br.com.gymback.core.enums.PaymentMethod;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PaymentDetailsDomain {
  private final Long id;
  private final PaymentDomain payment;
  private final PaymentMethod paymentMethod;
  private final BigDecimal value;
  private final BigDecimal paidValue;
}
