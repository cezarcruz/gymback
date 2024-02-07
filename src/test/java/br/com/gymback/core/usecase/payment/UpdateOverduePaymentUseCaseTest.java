/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.payment;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.gymback.core.enums.PaymentStatus;
import br.com.gymback.core.fixtures.PaymentFixture;
import br.com.gymback.core.gateway.payment.GetPaymentGateway;
import br.com.gymback.core.gateway.payment.SavePaymentGateway;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateOverduePaymentUseCaseTest {

  @Mock private GetPaymentGateway getPaymentGateway;

  @Mock private SavePaymentGateway savePaymentGateway;

  @InjectMocks private UpdateOverduePaymentUseCase updateOverduePaymentUseCase;

  @Test
  void shouldUpdateAllOverduePayments() {

    final var payments = List.of(PaymentFixture.getPayment());
    when(getPaymentGateway.findAllBy(PaymentStatus.PENDING, LocalDate.now())).thenReturn(payments);

    updateOverduePaymentUseCase.execute();

    verify(savePaymentGateway)
        .saveAll(
            argThat(
                argument -> {
                  var payment = argument.get(0);
                  return payment.getPaymentStatus().equals(PaymentStatus.OVERDUE);
                }));
  }
}
