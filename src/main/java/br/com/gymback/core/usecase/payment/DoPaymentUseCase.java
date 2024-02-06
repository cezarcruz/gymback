/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.payment;

import br.com.gymback.core.domain.ContractDomain;
import br.com.gymback.core.domain.PaymentDetailsDomain;
import br.com.gymback.core.domain.PaymentDomain;
import br.com.gymback.core.enums.PaymentStatus;
import br.com.gymback.core.exceptions.ContractNotFoundException;
import br.com.gymback.core.exceptions.PaymentNotFoundException;
import br.com.gymback.core.gateway.contract.GetContractGateway;
import br.com.gymback.core.gateway.payment.SavePaymentGateway;
import br.com.gymback.core.gateway.paymentdetails.SavePaymentDetailsGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class DoPaymentUseCase {

  private final GetContractGateway getContractGateway;
  private final SavePaymentGateway savePaymentGateway;
  private final SavePaymentDetailsGateway savePaymentDetailsGateway;

  public PaymentDomain doPayment(final PaymentDomain requestPaymentDomain, final Long contractId) {
    return getContractGateway
        .findById(contractId)
        .map(contract -> doPayment(requestPaymentDomain, contract))
        .orElseThrow(() -> new ContractNotFoundException(contractId));
  }

  private PaymentDomain doPayment(
      final PaymentDomain requestPaymentDomain, final ContractDomain contract) {
    var toPay = getPaymentToPay(requestPaymentDomain, contract);
    var paymentDetail =
        new PaymentDetailsDomain(
            null,
            toPay,
            requestPaymentDomain.getPaymentMethod(),
            toPay.getValue(),
            requestPaymentDomain.getValue());
    savePaymentDetailsGateway.save(paymentDetail);
    return savePaymentGateway.save(toPay);
  }

  private static PaymentDomain getPaymentToPay(
      final PaymentDomain paymentDomain, final ContractDomain contract) {
    return contract
        .getPaymentById(paymentDomain.getId())
        .map(DoPaymentUseCase::setPaymentValues)
        .orElseThrow(() -> new PaymentNotFoundException(paymentDomain.getId()));
  }

  private static PaymentDomain setPaymentValues(final PaymentDomain payment) {
    return payment.toBuilder().paymentStatus(PaymentStatus.PAID).build();
  }
}
