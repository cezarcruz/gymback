package br.com.gymback.core.domain;

import br.com.gymback.core.enums.PaymentMethod;
import br.com.gymback.core.enums.PaymentStatus;
import br.com.gymback.core.enums.PaymentType;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;

@Builder(toBuilder = true)
public record PaymentDomain(
    Long id,
    BigDecimal value,
    LocalDate paymentDay,
    PaymentType paymentType,
    PaymentStatus paymentStatus,
    PaymentMethod paymentMethod
) {

}
