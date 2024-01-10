package br.com.gymback.core.usecase.payment;

import br.com.gymback.core.domain.PaymentDomain;
import br.com.gymback.core.gateway.payment.GetPaymentGateway;
import jakarta.inject.Named;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class GetStudentPaymentUseCase {

  private final GetPaymentGateway getPaymentGateway;

  public List<PaymentDomain> getBy(final String studentId) {
    return getPaymentGateway.getByStudent(studentId);
  }

}
