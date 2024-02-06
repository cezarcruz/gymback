package br.com.gymback.core.usecase.payment;

import br.com.gymback.core.domain.PaymentDomain;
import br.com.gymback.core.enums.PaymentStatus;
import br.com.gymback.core.exceptions.ContractNotFoundException;
import br.com.gymback.core.gateway.contract.GetContractGateway;
import br.com.gymback.core.gateway.payment.GetPaymentGateway;
import jakarta.inject.Named;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class GetPaymentUseCase {
  private final GetPaymentGateway getPaymentGateway;
  private final GetContractGateway getContractGateway;

  public List<PaymentDomain> findBy(final Long contractId, final PaymentStatus paymentStatus) {

    if (getContractGateway.notExists(contractId)) {
      throw new ContractNotFoundException(contractId);
    }

    return getPaymentGateway.findBy(contractId, paymentStatus);
  }
}
