package br.com.cezarcruz.gymback.core.domain;

import br.com.cezarcruz.gymback.core.enums.PaymentType;
import java.math.BigDecimal;
import java.time.LocalDate;

public record Payment(
    String id,
    BigDecimal value,
    LocalDate paymentDay,
    PaymentType paymentType
) {

}
