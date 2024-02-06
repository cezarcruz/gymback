package br.com.gymback.application.rest.dto.request;

import br.com.gymback.core.enums.PaymentMethod;
import java.math.BigDecimal;

public record DoPaymentRequest(
    BigDecimal value,
    PaymentMethod method
) {
}
