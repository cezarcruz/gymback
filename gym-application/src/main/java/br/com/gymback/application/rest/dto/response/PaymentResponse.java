package br.com.gymback.application.rest.dto.response;

import br.com.gymback.core.enums.PaymentType;
import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentResponse(
    String id,
    BigDecimal value,
    LocalDate paymentDay,
    PaymentType paymentType
) {

}
