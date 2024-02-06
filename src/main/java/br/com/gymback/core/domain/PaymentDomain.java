/* Under MIT License (C)2024 */
package br.com.gymback.core.domain;

import br.com.gymback.core.enums.PaymentMethod;
import br.com.gymback.core.enums.PaymentStatus;
import br.com.gymback.core.enums.PaymentType;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder(toBuilder = true)
@Getter
@RequiredArgsConstructor
public final class PaymentDomain {

  private final Long id;
  private final BigDecimal value;
  private final LocalDate paymentDay;
  private final PaymentType paymentType;
  private final PaymentStatus paymentStatus;
  private final PaymentMethod paymentMethod;

  public static PaymentDomain createInPayment(
      final BigDecimal classValue, final LocalDate paymentDay) {
    return new PaymentDomain(
        null, classValue, paymentDay, PaymentType.IN, PaymentStatus.PENDING, null);
  }
}
