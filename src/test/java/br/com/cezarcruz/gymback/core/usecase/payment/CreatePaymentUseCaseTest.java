package br.com.cezarcruz.gymback.core.usecase.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.cezarcruz.gymback.core.enums.PaymentStatus;
import br.com.cezarcruz.gymback.core.enums.PaymentType;
import br.com.cezarcruz.gymback.fixtures.ContractFixtures;
import br.com.cezarcruz.gymback.core.gateway.payment.SavePaymentGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreatePaymentUseCaseTest {

  @Mock
  private SavePaymentGateway savePaymentGateway;

  @InjectMocks
  private CreatePaymentUseCase createPaymentUseCase;

  @Test
  void shouldCreatePayment() {

    when(savePaymentGateway.saveAll(any()))
        .thenAnswer(a -> a.getArgument(0));

    var contract = ContractFixtures.withOneYearInterval();
    var payments = createPaymentUseCase.create(contract);

    assertNotNull(payments);
    assertEquals(12, payments.size());

    payments.forEach(payment -> {
      assertEquals(10, payment.paymentDay().getDayOfMonth());
      assertEquals(PaymentType.IN, payment.paymentType());
      assertEquals(PaymentStatus.PENDING, payment.paymentStatus());
    });

    verify(savePaymentGateway, times(1)).saveAll(any());

  }

}